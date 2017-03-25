package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import sample.Main;
import sample.ScreensController;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddQuestionFormController implements Initializable, ControlledScreen {
    private ScreensController myController;
    @FXML private Pane container_for_questons;

    @FXML
    private void cancel() throws IOException {
        myController.setScreen(Main.main);
    }

    @FXML
    private void addVote() throws IOException {
        myController.setScreen(Main.main);
    }

    private double layoutX_for_textfield = 23.0;
    private double layoutX_for_button= 708.0;
    private double layoutY = 70.0;
    private int ids = 2;
    @FXML
    private void addField(){

        TextField newQuestion = new TextField();
        Button newQuestionButtonDelete = new Button("Usuń");
        newQuestion.setId("questionTextfield"+ids);
        newQuestionButtonDelete.setId("questionButtonDelete"+ids);
        ids+=1;
        newQuestion.setPrefWidth(650);
        newQuestion.setLayoutX(layoutX_for_textfield);
        newQuestion.setLayoutY(layoutY);
        newQuestionButtonDelete.setLayoutX(layoutX_for_button);
        newQuestionButtonDelete.setLayoutY(layoutY);
        layoutY+=40.0;
        container_for_questons.getChildren().addAll(newQuestion,newQuestionButtonDelete);

      //  container_for_questons.getChildren().add(new TextField());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }
}
