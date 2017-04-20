package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import sample.Main;
import sample.ScreensController;
import sample.database.Questionforms;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddQuestionFormController implements Initializable, ControlledScreen {
    public TextField new_questionform_name;
    public Label add_new_qf_message;
    public Button deleteQuestionBtn;
    private ScreensController myController;
    @FXML
    private Pane container_for_questons;

    public ArrayList<TextField> newQuestions = new ArrayList<>();

    @FXML
    private void cancel() throws IOException {
        myController.setScreen(Main.main);
    }

    @FXML
    private void addVote() throws IOException, SQLException, ClassNotFoundException {
        String qf_name = new_questionform_name.getText();
        add_new_qf_message.setText("");
        if (qf_name == null || qf_name.length() < 2) {
            add_new_qf_message.setText("Nie uzupełniono nazwy");
        } else {
            boolean all_questions = true;

            for (int i = 0; i < newQuestions.size(); i++) {
                if (newQuestions.get(i).getText() == null || newQuestions.get(i).getText().length() < 3) {
                    add_new_qf_message.setText("Nie uzupełniono wszystkich pytan");
                    all_questions = false;
                    break;
                }
            }

            if (all_questions) {
                Questionforms.add_new_questionform(qf_name, newQuestions);
                add_new_qf_message.setText("Pomyslnie dodano ankiete");
            }
        }

        //myController.setScreen(Main.main);
    }

    // do ustawiania textfieldow
    private double layoutX_for_textfield = 23.0;
    private double layoutY = 30.0;
    private int ids = 1;


    private void showFields() {
        // by nie kusilo klikać deleta gdy pytań za mało
        if (newQuestions.size() < 2) {
            deleteQuestionBtn.setDisable(true);
        } else {
            deleteQuestionBtn.setDisable(false);
        }

        // check na konsole
        for (int i = 0; i < newQuestions.size(); i++) {
            System.out.println(newQuestions.get(i));
        }
        System.out.println("----------");


        // czyszczenie by nie dublowało
        container_for_questons.getChildren().removeAll(newQuestions);

        // ustawiamy pola
        layoutY=20.0;
        for(int i=0;i<newQuestions.size();i++){

            TextField new_field = newQuestions.get(i);
            new_field.setLayoutX(layoutX_for_textfield);
            new_field.setLayoutY(layoutY);
            layoutY += 40.0;
            // gdy trzeba wydluzyc container
            if (layoutY > 370.0) {
                container_for_questons.setPrefHeight(container_for_questons.getHeight() + 40.0);
            }
        }

        // dodajemy
        container_for_questons.getChildren().addAll(newQuestions);

    }

    @FXML
    public void delField() {
        // musi byc bo inaczej textfield nie znika o_O
        newQuestions.get(newQuestions.size() - 1).setVisible(false);
        newQuestions.remove(newQuestions.size() - 1);
        showFields();
    }

    @FXML
    private void addField() {
        //inicjacja, ustawienie id, dlugosci i dodanie do arraylista
        TextField new_field = new TextField();
        new_field.setId("field" + ids);
        new_field.setPrefWidth(730);
        ids += 1;
        newQuestions.add(new_field);
        showFields();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }


}


// kopia w razie gdyby cos sie popsulo

/*
*
*
* package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import sample.Main;
import sample.ScreensController;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddQuestionFormController implements Initializable, ControlledScreen {
    public TextField new_questionform_name;
    public Label add_new_qf_message;
    private ScreensController myController;
    @FXML
    private Pane container_for_questons;

    public TextField newQuestions[];

    @FXML
    private void cancel() throws IOException {
        myController.setScreen(Main.main);
    }

    @FXML
    private void addVote() throws IOException {
        String qf_name = new_questionform_name.getText();
        add_new_qf_message.setText("");
        if (qf_name == null || qf_name.length() < 2) {
            add_new_qf_message.setText("Nie uzupełniono nazwy");
        }

        System.out.println(container_for_questons.getChildren().size());
        int number_of_questions = (container_for_questons.getChildren().size() - 1) / 2;

        number_of_questions += 1;

        System.out.println("pytan: " + number_of_questions);

        ArrayList<String> questions = new ArrayList<>();
        for(int i=0;i<number_of_questions;i++){
            TextField question = (TextField)container_for_questons.lookup("#questionTextfield"+i);
            System.out.println(question.getText());
        }


        //myController.setScreen(Main.main);
    }

    private double layoutX_for_textfield = 23.0;
    private double layoutX_for_button = 708.0;
    private double layoutY = 70.0;
    private int ids = 2;

    @FXML
    private void addField() {

        TextField newQuestion = new TextField();
        Button newQuestionButtonDelete = new Button("Usuń");
        newQuestion.setId("questionTextfield" + ids);
        newQuestionButtonDelete.setId("questionButtonDelete" + ids);
        newQuestionButtonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id = newQuestionButtonDelete.getId();
                if (id.length() == 21) {
                    char pom = id.toCharArray()[id.length()- 1];
                    id = pom + "";
                } else {
                    char pom1 = id.toCharArray()[id.length() - 2];
                    char pom2 = id.toCharArray()[id.length() - 1];
                    id = pom1 +""+ pom2;
                }


                System.out.println("usuwamy id " + id);
                //container_for_questons.getChildren().remove(newQuestion.getId()=="questionTextfield"+id);
                container_for_questons.getChildren().remove(container_for_questons.lookup("#questionTextfield" + id));
                container_for_questons.getChildren().remove(container_for_questons.lookup("#questionButtonDelete" + id));
            }
        });
        ids += 1;
        newQuestion.setPrefWidth(650);
        newQuestion.setLayoutX(layoutX_for_textfield);
        newQuestion.setLayoutY(layoutY);
        newQuestionButtonDelete.setLayoutX(layoutX_for_button);
        newQuestionButtonDelete.setLayoutY(layoutY);
        layoutY += 40.0;
        if (layoutY > 370.0) {
            container_for_questons.setPrefHeight(container_for_questons.getHeight() + 40.0);
        }
        container_for_questons.getChildren().addAll(newQuestion, newQuestionButtonDelete);

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

*
* */
