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

public class FillVoteController implements ControlledScreen, Initializable {

    private ScreensController myController;

    @FXML
    private void sendVote(ActionEvent event) throws IOException {
        myController.setScreen(Main.main);
    }

    @FXML
    private void cancelVote(ActionEvent event) throws IOException {
        myController.setScreen(Main.main);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }
}
