package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import sample.Main;
import sample.ScreensController;
import sample.interfaces.ControlledScreen;
import sample.configuration.Logged;

public class LoginController implements Initializable, ControlledScreen {

    private ScreensController myController;

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    TextField login;
    @FXML
    TextField password;

    @FXML
    private void login() throws IOException {
        //w zaleznosci kto sie zalogowal, ustawiamy pracodawca/kierownik/pracownik
        Logged.setWho("kierownik");

        myController.loadScreen( Main.main,Main.mainView);
        myController.setScreen(Main.main);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
