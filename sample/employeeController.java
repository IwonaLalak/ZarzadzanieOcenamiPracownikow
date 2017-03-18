package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class employeeController {

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }

    @FXML
    private void changePassword(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("password_change.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }

}
