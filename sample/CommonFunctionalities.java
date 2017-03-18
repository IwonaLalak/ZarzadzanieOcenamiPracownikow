package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class CommonFunctionalities {

    public static void showWindow(ActionEvent event, Parent parent) {
        Scene loginScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.hide();
        appStage.setScene(loginScene);
        appStage.show();
    }
}
