package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.ScreensController;
import sample.configuration.Logged;
import sample.database.Model;
import sample.database.Users;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PasswordChangeController implements Initializable, ControlledScreen {

    ScreensController myController;
    
    @FXML
    TextField password;
    
    @FXML
    TextField secpassword;
    
    @FXML
    Label error;
    
    @FXML
    Label success;
    
    @FXML
    private void goBackToMainPage(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        myController.setScreen(Main.main);
    }

    @FXML
    private void changePassword(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        error.setText("");
        success.setText("");
        
        System.out.println( Logged.username );
        if( ! password.getText().equals( secpassword.getText()) ){
            error.setText("Hasła się nie zgadzają!");
            myController.setScreen(Main.change_password);
            return;
        }
        Model usersRepo = new Users();
        int id = usersRepo.getIdByUsername( Logged.username );
        Model loggedUserModel = usersRepo.find( id );
        loggedUserModel.set( "password", password.getText());
        loggedUserModel.save();
        
        success.setText("Hasło zostało zmienione!");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }

    public ScreensController getScreenController() {
        return this.myController;
    }
}
