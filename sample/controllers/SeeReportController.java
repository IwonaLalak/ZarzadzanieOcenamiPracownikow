package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Main;
import sample.ScreensController;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import sample.database.entity.Raports;

public class SeeReportController implements Initializable, ControlledScreen {

    private ScreensController myController;

    @FXML
    public Label reportTitle;
    
    @FXML 
    public Label reportContent;
    
    
    @FXML
    private void goBackToReports(ActionEvent event) throws IOException {
        this.reportContent.setText("");
        myController.setScreen(Main.main);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @Override
    public void setScreenParent(ScreensController screenPage) {
        
        this.myController = screenPage;
    }
   
    public void preLoad(Raports selectedRaport )
    {
        
        this.reportTitle.setText(selectedRaport.getRaport_name());
        
        try{
            
            String[] reportContent = selectedRaport.getRaport_content().split("<br/>");
            if(reportContent.length < 1)
            {
                this.reportContent.setText("Brak danych!");
                return;
            }

            StringBuilder content = new StringBuilder();
            for (String line : reportContent) {
                String[] segments = line.split(";");

                content.append(segments[0]).append(" ocenił pytanie \" ").append(segments[2]).append("\" na ").append(segments[1]).append("\n");
            }

           this.reportContent.setText(content.toString());
        }
        catch( Exception e)
        {
            this.reportContent.setText("Dane niepoprawne lub ich brak!");
        }
    }
    
    public Initializable getSeeReportController()
    {
        return this;
    }
}
