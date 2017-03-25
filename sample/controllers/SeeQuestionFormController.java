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

public class SeeQuestionFormController implements Initializable, ControlledScreen {
    private ScreensController myController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void goBackToQuestionForms(ActionEvent event) throws IOException {
        myController.setScreen(Main.main);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }

/*    @FXML
    private void cancel() throws IOException {
        this.myController.setScreen(Main.);
    }*/
}
