package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPanelController implements ControlledScreen, Initializable {

    private ScreensController myController;

    @FXML
    private void showRaport() throws IOException {
        myController.setScreen(Main.see_report);
    }

    @FXML
    private void logout() throws IOException {
        myController.setScreen(Main.login);
    }

    @FXML
    private void changePassword(ActionEvent event) throws IOException {
        myController.setScreen(Main.change_password);
    }

    @FXML
    private void fillVote() throws IOException {
        myController.setScreen(Main.fill_vote);
    }

    @FXML
    private void createNewVote() throws IOException {
        myController.setScreen(Main.create_new_vote);
    }

    @FXML
    private void newVote() throws IOException {
        myController.setScreen(Main.create_new_vote);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
