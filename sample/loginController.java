package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class loginController {

    @FXML
    TextField login;
    @FXML
    TextField password;

    @FXML
    private void login(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("main_panel.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }

}
