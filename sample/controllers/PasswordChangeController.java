package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Main;
import sample.ScreensController;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.configuration.Logged;
import sample.database.Model;
import sample.database.Users;
/**
 * Klasa zmiany hasla dla uzytokownika
 */
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
    /**
     * przycisko powrotu do glownego okna
     */
    @FXML
    private void goBackToMainPage(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        myController.setScreen(Main.main);
    }

    /**
     * metoda zmiany hasla przez pracownikow
     */

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
    /**
     * Metoda, która rozpoczyna się automatycznie w tej klasie.
     * @param location polozenie
     * @param resources zasoby
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    /**
     * Zmienia okno nadrzędne określonego okna podrzędnego.
     * @param screenPage okno przesylane na ekran
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }
}
