package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import sample.Main;
import sample.ScreensController;
import sample.database.UsersFactory;
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
    Label error;

    @FXML
    private void login() throws IOException, SQLException, ClassNotFoundException {

        String log = login.getText();
        String pass = password.getText() ;
        error.setText(" ");
        if(log!=null && pass!=null && !(log.isEmpty()) &&!(pass.isEmpty())){
            System.out.println("Logowanie: "+log+" "+pass);
            String msg = UsersFactory.login(log,pass);
            System.out.println(msg);
            if (msg.isEmpty()){
                error.setText("Złe dane logowania");
                // msg="kierownik";
            }else{
                Logged.setWho(msg);
                Logged.setUsername(log);
                myController.loadScreen( Main.main,Main.mainView);
                myController.setScreen(Main.main);
            }


        }
        else{
            error.setText("Uzupełnij login i/lub hasło");
        }
        //w zaleznosci kto sie zalogowal, ustawiamy pracodawca/kierownik/pracownik

       // UsersFactory.login();



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
