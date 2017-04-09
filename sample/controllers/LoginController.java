package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import sample.Main;
import sample.ScreensController;
import sample.database.Database;
import sample.database.Users;
import sample.interfaces.ControlledScreen;
import sample.configuration.Logged;

import javax.xml.transform.Result;

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
    private void login() throws IOException, SQLException {

        String log = login.getText();
        String pass = password.getText() ;
        error.setText(" ");
        if(log!=null && pass!=null && !(log.isEmpty()) &&!(pass.isEmpty())){
            System.out.println("Logowanie: "+log+" "+pass);
            String msg = Users.login(log,pass);
            System.out.println(msg);
            if (msg.isEmpty()){
                error.setText("Złe dane logowania");
                // msg="kierownik";
            }else{
                Logged.setWho(msg);

                myController.loadScreen( Main.main,Main.mainView);
                myController.setScreen(Main.main);
            }


        }
        else{
            error.setText("Uzupełnij login i/lub hasło");
        }
        //w zaleznosci kto sie zalogowal, ustawiamy pracodawca/kierownik/pracownik

       // Users.login();



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
