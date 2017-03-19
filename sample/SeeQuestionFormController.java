package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SeeQuestionFormController implements Initializable, ControlledScreen {
    private ScreensController myController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }

    @FXML
    private void cancel() throws IOException {
//        this.myController.setScreen(Main.);
    }
}
