package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ReportController {

    @FXML
    private void goBackToReports(ActionEvent event) throws IOException {
        //get somehow access to MainPanelController Tab
        Parent parent = FXMLLoader.load(getClass().getResource("see_report.fxml"));
        CommonFunctionalities.showWindow(event,parent);
    }

}
