package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import sample.Main;
import sample.ScreensController;
import sample.database.Database;
import sample.database.Sections;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainPanelController implements ControlledScreen, Initializable {

    public TextField new_section_name;
    private ScreensController myController;

    @FXML
    public TabPane tabs;

    @FXML
    private void showRaport() throws IOException {
        myController.setScreen(Main.see_report);
    }
    @FXML
    private void showQuestionForm() throws IOException {
        myController.setScreen(Main.see_question_form);
    }
    @FXML
    private void showVote() throws IOException {
        myController.setScreen(Main.see_vote);
    }

    @FXML
    private void logout() throws IOException {
        myController.setScreen(Main.login);
    }

    @FXML
    private void changePassword(ActionEvent event) throws IOException {
        myController.setScreen(Main.change_password);
    }

    @FXML
    private void fillVote() throws IOException {
        myController.setScreen(Main.fill_vote);
    }

    /*@FXML
    private void createNewVote() throws IOException {
        myController.setScreen(Main.create_new_vote);
    }*/

    @FXML
    private void createNewQuestionForm() throws IOException {
        myController.setScreen(Main.add_question_form);
    }



    @FXML
    private void newVote() throws IOException {
        myController.setScreen(Main.create_new_vote);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void show_all_employes() throws SQLException {
        ResultSet result = Database.execute("SELECT users.id,users.firstname,users.lastname,users.type,sectors.name FROM users,sectors where users.sector_id=sectors.id ");
        while(result.next()){
            System.out.print(result.getString("id")+" - ");
            System.out.print(result.getString("firstname")+" - ");
            System.out.print(result.getString("lastname")+" - ");
            System.out.print(result.getString("name")+" - ");
            System.out.println(result.getString("type"));
        }
    }


    @FXML
    private void show_all_sectors() throws SQLException {
        ResultSet result = Database.execute("SELECT * FROM sectors");
        while(result.next()){
            System.out.print(result.getString("id")+" - ");
            System.out.println(result.getString("name"));
        }
    }

    @FXML
    private void show_all_questionforms() throws SQLException {
        ResultSet result = Database.execute("SELECT * FROM questionforms");
        while(result.next()){
            System.out.print(result.getString("id")+" - ");
            System.out.print(result.getString("name")+" - ");
            System.out.print(result.getString("creation_date")+" - ");
            System.out.println(result.getString("number_of_questions"));
        }
    }


    @FXML
    private void show_all_votes() throws SQLException {
        ResultSet result = Database.execute("SELECT *,questionforms.name as questionform_name, sectors.name as sector_name FROM votes,sectors,questionforms WHERE votes.section_id = sectors.id AND votes.questionform_id=questionforms.id");
        while(result.next()){
            System.out.print(result.getString("id")+" - ");
            System.out.print(result.getString("vote_name")+" - ");
            System.out.print(result.getString("date_from")+" - ");
            System.out.print(result.getString("date_to")+" - ");
            System.out.print(result.getString("who")+" - ");
            System.out.print(result.getString("sector_name")+" - ");
            System.out.println(result.getString("questionform_name"));
        }
    }

    @FXML
    private void show_all_raports() throws SQLException {
        ResultSet result = Database.execute("SELECT * FROM raports,votes where raports.vote_id=votes.id");
        while(result.next()){
            System.out.print(result.getString("id")+" - ");
            System.out.print(result.getString("raport_name")+" - ");
            System.out.print(result.getString("vote_name")+" - ");
            System.out.println(result.getString("date"));
        }
    }

    @FXML
    private void add_new_section(){
        String get_name = new_section_name.getText();
        if(get_name!=null && get_name.length()>1){
            Sections.add_new_section(get_name);
        }

    }


}
