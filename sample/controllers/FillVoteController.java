package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sample.Main;
import sample.ScreensController;
import sample.database.QuestionFormsFactory;
import sample.database.UsersFactory;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class FillVoteController implements ControlledScreen, Initializable {

    public Pane place_for_questions;
    public Button loadDataBtn;
    private ScreensController myController;

    public ArrayList<Label> peopleArray = new ArrayList<>();
    public ArrayList<Label> questionArray = new ArrayList<>();
    public ArrayList<ComboBox> gradeArray = new ArrayList<>();


    @FXML
    private void sendVote(ActionEvent event) throws IOException {
        //   place_for_questions.getChildren().removeAll(peopleArray);
        myController.setScreen(Main.main);
    }

    @FXML
    private void cancelVote(ActionEvent event) throws IOException {
        loadDataBtn.setDisable(false);
        place_for_questions.getChildren().removeAll(peopleArray);
        place_for_questions.getChildren().removeAll(questionArray);
        place_for_questions.getChildren().removeAll(gradeArray);
        peopleArray.clear();
        questionArray.clear();
        gradeArray.clear();
        place_for_questions.setPrefHeight(450.0);
        myController.setScreen(Main.main);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }

    public void getArraysData() throws SQLException, ClassNotFoundException {
        String voteID = MainPanelController.voteID;
        System.out.println("voteid: " + voteID);

        loadDataBtn.setDisable(true);

        double layoutY = 5.00;
        double layoutXperson = 10.00;
        double layoutXquestion = 15.00;
        double layoutXcombobox = 615.00;

        if (voteID != null && !Objects.equals(voteID, "")) {
            peopleArray = UsersFactory.getPeopleToFillVote(voteID);
            ArrayList<Label> currentQuestionArray = QuestionFormsFactory.getQuestionsToFillVote(voteID);
            int all_number_of_questions = peopleArray.size() * currentQuestionArray.size();
            int current_index = 0;
            ObservableList<String> options =
                    FXCollections.observableArrayList(
                            "1",
                            "2",
                            "3",
                            "4",
                            "5"
                    );

            for (int i = 0; i < peopleArray.size(); i++) {

                peopleArray.get(i).setLayoutY(layoutY);
                peopleArray.get(i).setLayoutX(layoutXperson);
                System.out.println(peopleArray.get(i).getText());

                for (int j = 0; j < currentQuestionArray.size(); j++) {

                    if (current_index <= all_number_of_questions) {
                        layoutY += 30.00;
                        questionArray.add(new Label());
                        questionArray.get(current_index).setText(currentQuestionArray.get(j).getText());
                        questionArray.get(current_index).setLayoutY(layoutY);
                        questionArray.get(current_index).setLayoutX(layoutXquestion);
                        questionArray.get(current_index).setId("label" + i + "/" + j);

                        gradeArray.add(new ComboBox<String>(options));
                        gradeArray.get(current_index).setLayoutY(layoutY);
                        gradeArray.get(current_index).setLayoutX(layoutXcombobox);
                        gradeArray.get(current_index).setPrefWidth(120.00);
                        gradeArray.get(current_index).setId(peopleArray.get(i).getText() + ";" + questionArray.get(current_index).getText());

                        current_index++;
                        while (layoutY > place_for_questions.getPrefHeight() - 10.00)
                            place_for_questions.setPrefHeight(place_for_questions.getPrefHeight() + 50.00);

                    }
                }
                layoutY += 40.00;
            }
            /*double height = place_for_questions.getPrefHeight();
            if (height > 450.0)
                place_for_questions.setPrefHeight(height + 50.00);*/

            place_for_questions.getChildren().addAll(peopleArray);
            place_for_questions.getChildren().addAll(questionArray);
            place_for_questions.getChildren().addAll(gradeArray);
        }
    }


}
