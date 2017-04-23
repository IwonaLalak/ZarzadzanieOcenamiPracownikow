package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.ScreensController;
import sample.database.Database;
import sample.database.VotesFactory;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateNewVoteController implements Initializable, ControlledScreen {
    public ComboBox show_all_qf;
    public ComboBox show_all_sectors;
    public ComboBox show_all_types;
    public Label add_new_vote_msg;
    public TextField new_vote_name;
    public DatePicker new_vote_enddate;
    private ScreensController myController;


    public void fill_comboboxes() throws SQLException {
        // fill types of users
        show_all_types.getItems().addAll(
                "tylko kierownicy",
                "tylko pracownicy",
                "kierownicy i pracownicy"
        );

        // fill sectors
        ObservableList<String> sectors_names = FXCollections.observableArrayList();
        ResultSet result = Database.execute("SELECT * FROM sectors");
        while(result.next()){
            sectors_names.add(result.getString("name"));
        }

        show_all_sectors.setItems(sectors_names);


        // fill qf
        ObservableList<String> qf_names = FXCollections.observableArrayList();
        result = Database.execute("SELECT * FROM questionforms");
        while(result.next()){
            qf_names.add(result.getString("name"));
        }

        show_all_qf.setItems(qf_names);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            fill_comboboxes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancel() throws IOException {
        myController.setScreen(Main.main);
    }

    @FXML
    private void startNewVote() throws IOException, SQLException, ClassNotFoundException {

        add_new_vote_msg.setText("");

        String nv_name = new_vote_name.getText();
        LocalDate nv_enddate = new_vote_enddate.getValue();

        if(nv_name!=null&&nv_name.length()>1){
            // sprawdzenie czy wprowadzona data nie jest pusta i czy nie jest z przeszlosci
            if(nv_enddate!=null&&nv_enddate.isAfter(LocalDate.now())){

                // czy zostalo powybierane z comboboxow
                if(show_all_qf.getValue()!=null&&show_all_sectors.getValue()!=null&&show_all_types.getValue()!=null){

                    String nv_sector = show_all_sectors.getValue()+"";
                    String nv_who_can = show_all_types.getValue()+"";
                    String nv_qf_name = show_all_qf.getValue()+"";
                    VotesFactory.add_new_vote(nv_name,nv_enddate,nv_sector,nv_who_can,nv_qf_name);
                    add_new_vote_msg.setText("Pomyslnie rozpoczeto glosowanie");
                }
                else{
                    add_new_vote_msg.setText("Nie wybrano opcji z listy");
                }
            }
            else {
                add_new_vote_msg.setText("Niepoprawna data zakonczenia");
            }
        }
        else{
            add_new_vote_msg.setText("Niepoprawna nazwa");
        }



        //myController.setScreen(Main.main);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }
}
