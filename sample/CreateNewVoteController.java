package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewVoteController implements Initializable, ControlledScreen {
    private ScreensController myController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void cancel() throws IOException {
        myController.setScreen(Main.main);
    }

    @FXML
    private void startNewVote() throws IOException {
        myController.setScreen(Main.fill_vote);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }
}
