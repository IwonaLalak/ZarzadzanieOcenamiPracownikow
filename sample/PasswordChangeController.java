package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class PasswordChangeController {

    @FXML
    private void goBackToMainPage(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("main_panel.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }

}
