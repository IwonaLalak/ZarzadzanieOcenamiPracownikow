package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddQuestionFormController implements Initializable, ControlledScreen {
    private ScreensController myController;

    @FXML
    private void cancel() throws IOException {
        myController.setScreen(Main.create_new_vote);
    }

    @FXML
    private void addVote() throws IOException {
        myController.setScreen(Main.add_question_form);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }
}
