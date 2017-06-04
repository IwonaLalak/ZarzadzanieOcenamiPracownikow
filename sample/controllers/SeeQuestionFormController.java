package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import sample.Main;
import sample.ScreensController;
import sample.database.QuestionFormsFactory;
import sample.database.entity.QuestionForms;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * klasa pokazujaca konkretna ankiete
 */
public class SeeQuestionFormController implements Initializable, ControlledScreen {
    /**
     * panel ankiety
     */
    public Pane questionform_container;

    /**
     * label ladujacy ilos pytan
     */

    public Label qf_number_value;
    /**
     * label tekstowy ilos pytan
     */
    public Label qf_number_label;

    /**
     * label ladujacy date utworzenia
     */
    public Label qf_date_value;
    /**
     * label tekstowy z data utworzenia
     */
    public Label qf_date_label;

    /**
     * label ladujacy nazwe ankiety
     */
    public Label qf_name_value;
    /**
     * label tekstowy z nazwa ankiety
     */
    public Label qf_name_label;

    /**
     * label ladujacy id ankiety
     */
    public Label qf_id_value;
    /**
     * label tekstowy id ankiety
     */
    public Label qf_id_label;
    private ScreensController myController;
    /**
     * Metoda, która rozpoczyna się automatycznie w tej klasie.
     * @param location polozenie
     * @param resources zasoby
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        qf_id_label.setVisible(false);
        qf_name_label.setVisible(false);
        qf_date_label.setVisible(false);
        qf_number_label.setVisible(false);
    }
    /**
     *  przycisk powrotu do wszystkich ankiet
     * @param event obsluguje powrot do ankiet
     */
    @FXML
    private void goBackToQuestionForms(ActionEvent event) throws IOException {
        qf_id_label.setVisible(false);
        qf_name_label.setVisible(false);
        qf_date_label.setVisible(false);
        qf_number_label.setVisible(false);
        qf_id_value.setText("");
        qf_name_value.setText("");
        qf_date_value.setText("");
        qf_number_value.setText("");
        questionform_container.getChildren().removeAll();
        questionform_container.getChildren().clear();
        myController.setScreen(Main.main);
    }
    /**
     * Zmienia okno nadrzędne określonego okna podrzędnego.
     * @param screenPage okno przesylane na ekran
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }

    public void loadQuestionformData(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(MainPanelController.selected_questionformID!=null){
            String data[] = QuestionFormsFactory.getQuestionformData(MainPanelController.selected_questionformID);
            qf_id_label.setVisible(true);
            qf_name_label.setVisible(true);
            qf_date_label.setVisible(true);
            qf_number_label.setVisible(true);

            qf_id_value.setText(data[0]);
            qf_name_value.setText(data[1]);
            qf_date_value.setText(data[2]);
            qf_number_value.setText(data[3]);

            ArrayList<String> questions = QuestionFormsFactory.getQuestionform_questions(MainPanelController.selected_questionformID);
            double layoutX = 35.00;
            double layoutY = 25.00; // do kolejnego +25
            for(int i=0; i<questions.size();i++){
                Label show_question = new Label();
                show_question.setText(questions.get(i));
                show_question.setLayoutX(layoutX);
                show_question.setLayoutY(layoutY);
                show_question.setFont(Font.font(16.00));
                layoutY+=25.00;
                questionform_container.getChildren().add(show_question);
            }

        }
    }

}
