package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;

import java.io.IOException;

public class MainPanelController {

    @FXML
    TabPane tabs;

    public TabPane getTabs() {
        return tabs;
    }

    @FXML
    private void showRaport(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("see_report.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }

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

    @FXML
    private void fillVote(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("fill_vote.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }


}
