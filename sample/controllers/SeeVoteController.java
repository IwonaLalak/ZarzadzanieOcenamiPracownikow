package sample.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sample.Main;
import sample.ScreensController;
import sample.database.Database;
import sample.database.VotesFactory;
import sample.database.entity.Logs;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * klasa odpowiadajaca za podglad przebiegu glosowania
 */
public class SeeVoteController implements Initializable, ControlledScreen {
    /**
     * label z nazwa glosowania
     */
    public Label vote_name;
    /**
     * podglad logow glosowania
     */
    public ListView log_list;
    /**
     * podglad osob ktore nie oddaly glosu
     */
    public ListView people_list;
    private ScreensController myController;


    @FXML
    private void goBackToVotes(ActionEvent event) throws IOException {
        log_list.getItems().clear();
        people_list.getItems().clear();
        vote_name.setText("");

        myController.setScreen(Main.main);
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

    public ScreensController getScreenController() {
        return this.myController;
    }


    /**
     * ladowanie danych dotyczacych glosowania
     * @param actionEvent action
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public void showVoteData(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (MainPanelController.selected_voteID_toSee != null) {
            vote_name.setText(VotesFactory.getSelectedVoteName(MainPanelController.selected_voteID_toSee));

            // logi
            ResultSet rs = Database.execute("SELECT * FROM logs WHERE vote_id=" + MainPanelController.selected_voteID_toSee);
            ObservableList<String> logs = FXCollections.observableArrayList();
            while (rs.next()) {
                logs.add((rs.getString("date") + " - " + rs.getString("log_content")));
            }
            if (logs.size() == 0) {
                logs.add("Brak pozycji");
            }
            this.log_list.setItems(logs);

            // kto nie glosowal
            rs = Database.execute("SELECT users.firstname, users.lastname FROM user_fill_vote, users WHERE users.id = user_fill_vote.user_id AND user_fill_vote.filled=0 AND user_fill_vote.vote_id=" + MainPanelController.selected_voteID_toSee);
            ObservableList<String> people = FXCollections.observableArrayList();
            while (rs.next()) {
                people.add((rs.getString("firstname")) + " " + rs.getString("lastname"));
            }
            if (people.size() == 0) {
                people.add("Brak pozycji");
            }
            this.people_list.setItems(people);


        }
    }
}
