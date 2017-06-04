package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import sample.Main;
import sample.ScreensController;
import sample.database.QuestionFormsFactory;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * Klasa dodawania ankiet do wypelnienia
 */
public class AddQuestionFormController implements Initializable, ControlledScreen {
    /**
     * new_questionform_name nazwa ankiety
     */
    public TextField new_questionform_name;
    /**
     * add_new_qf_message cos
     */
    public Label add_new_qf_message;
    /**
     * deleteQuestionBtn usuwa pytania
     */
    public Button deleteQuestionBtn;
    private ScreensController myController;
    @FXML
    private Pane container_for_questons;
    /**
     * newQuestions dodawanie pytania do arraylisty
     */
    public ArrayList<TextField> newQuestions = new ArrayList<>();

    @FXML
    private void cancel() throws IOException {
        myController.setScreen(Main.main);
    }
    /**
     * dodawanie ankiety
     */

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
                QuestionFormsFactory.add_new_questionform(qf_name, newQuestions);
                add_new_qf_message.setText("Pomyslnie dodano ankiete");
            }
        }

        //myController.setScreen(Main.main);
    }
    /**
     * ustawianie textfieldó
     */
    private double layoutX_for_textfield = 23.0;
    private double layoutY = 30.0;
    private int ids = 1;

    /**
     * usuwanie pytań dostępne podczas tworzenia ankiety
     */
    private void showFields() {
        // by nie kusilo klikać deleta gdy pytań za mało
        if (newQuestions.size() < 2) {
            deleteQuestionBtn.setDisable(true);
        } else {
            deleteQuestionBtn.setDisable(false);
        }

        /**
         * sprawdzanie na konsoli czy pytanie zostało dodane
         */
        for (int i = 0; i < newQuestions.size(); i++) {
            System.out.println(newQuestions.get(i));
        }
        System.out.println("----------");


        /**
         * czyszczenie by nie dublowało
         */
        container_for_questons.getChildren().removeAll(newQuestions);

        /**
         * ustawianie pola
         */
        layoutY = 20.0;
        for (int i = 0; i < newQuestions.size(); i++) {

            TextField new_field = newQuestions.get(i);
            new_field.setLayoutX(layoutX_for_textfield);
            new_field.setLayoutY(layoutY);
            layoutY += 40.0;
            // gdy trzeba wydluzyc container
            if (layoutY > 370.0) {
                container_for_questons.setPrefHeight(container_for_questons.getHeight() + 40.0);
            }
        }

        /**
         * dodawanie containera
         */
        container_for_questons.getChildren().addAll(newQuestions);

    }
    /**
     * odpowiedzalny za znikanie textfielda
     */
    @FXML
    public void delField() {
        // musi byc bo inaczej textfield nie znika o_O
        newQuestions.get(newQuestions.size() - 1).setVisible(false);
        newQuestions.remove(newQuestions.size() - 1);
        showFields();
    }
    /**
     * dodawanie pol
     */
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

    /**
     * Metoda, która rozpoczyna się automatycznie w tej klasie.
     * @param location polozenie
     * @param resources zasoby
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    /**
     * Zmienia okno nadrzędne określonego okna podrzędnego.
     * @param screenPage okno przesylane na ekran
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }
}

