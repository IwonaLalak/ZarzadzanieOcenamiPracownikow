package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;

import java.io.IOException;

/**
 * Created by kon_o on 19/03/2017.
 */
public class FillVoteController {

    @FXML
    private void sendVote(ActionEvent event) throws IOException {
        //get somehow access to MainPanelController Tab
        Parent parent = FXMLLoader.load(getClass().getResource("main_panel.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }

    @FXML
    private void cancelVote(ActionEvent event) throws IOException {
        //get somehow access to MainPanelController Tab
        Parent parent = FXMLLoader.load(getClass().getResource("main_panel.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }
}
