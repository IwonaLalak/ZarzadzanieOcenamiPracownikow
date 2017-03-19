package sample;

import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import sample.configuration.Logged;
import sample.configuration.LoggedUserTabs;


public class ScreensController extends StackPane {
    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController() {
        super();
    }

    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public Node getScreen(String name) {
        return screens.get(name);
    }

    public boolean loadScreen(String name, String resource) {

        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();

            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            //System.out.println( myScreenControler.getClass().getName());
            if ( myScreenControler.getClass().getName().equals("sample.MainPanelController") ){

                MainPanelController main = (MainPanelController) myScreenControler;

                String whoIsLogged = Logged.whoIsLogged();
                String[] tabsToDisplay = LoggedUserTabs.getTabConfiguration( whoIsLogged );

                Tab allTabs = main.tabs.getTabs().get(1);

                for(int i = 0; i < main.tabs.getTabs().size(); i++){
                    for(String tabName : tabsToDisplay){
                        if( main.tabs.getTabs().get( i ).getText().equals( tabName )){
                            main.tabs.getTabs().remove( main.tabs.getTabs().get(i) );
                        }
                    }
                }

            }
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name) {

        if (screens.get(name) != null) {   //screen loaded
            if (!getChildren().isEmpty()) {    //if there is more than one screen
                getChildren().remove(0);                    //remove the displayed screen
                getChildren().add(0, screens.get(name));     //add the screen

            } else {
                getChildren().add(screens.get(name));       //no one else been displayed, then just show
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }

    }

}