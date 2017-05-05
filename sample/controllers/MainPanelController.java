package sample.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.Main;
import sample.ScreensController;
import sample.database.Database;
import sample.database.SectionsFactory;
import sample.database.UsersFactory;
import sample.database.entity.Users;
import sample.database.entity.Raports;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import sample.database.entity.QuestionForms;
import sample.database.entity.Votes;
import sample.database.entity.Sectors;

public class MainPanelController implements ControlledScreen, Initializable {

    public TextField new_section_name;
    public ComboBox select_type;
    public ComboBox select_sector;
    public TextField get_firstname;
    public TextField get_lastname;
    public Label add_new_employee_message;
    public Label add_new_sector_message;
    private ScreensController myController;

    @FXML
    private TableView<Raports> raportTable;
    @FXML
    private TableColumn<Raports, Number> raportColumnId;
    @FXML
    private TableColumn<Raports, String> raportColumnName;
    @FXML
    private TableColumn<Raports, String> raportColumnDate;


    @FXML
    private TableView<Votes> glosujTable;
    @FXML
    private TableColumn<Votes, Number> glosujColumnNumer;
    @FXML
    private TableColumn<Votes, String> glosujColumnNazwa;
    @FXML
    private TableColumn<Votes, String> glosujColumnData;
    @FXML
    private TableColumn<Votes, String> glosujColumnStatus;


    @FXML
    private TableView<Users> employeeTable;
    @FXML
    private TableColumn<Users, Number> employeeColumnId;
    @FXML
    private TableColumn<Users, String> employeeColumnName;
    @FXML
    private TableColumn<Users, String> employeeColumnLastName;
    @FXML
    private TableColumn<Users, String> employeeColumnType;

    @FXML
    private TableView<Sectors> sectorsTable;
    @FXML
    private TableColumn<Sectors, Number> sectorsColumnId;
    @FXML
    private TableColumn<Sectors, String> sectorsColumnName;
    @FXML
    private TableColumn<Sectors, String> sectorsColumnManager;

    @FXML
    private TableView<QuestionForms> questionformsTable;
    @FXML
    private TableColumn<QuestionForms, Number> questionformsColumnId;
    @FXML
    private TableColumn<QuestionForms, String> questionformsColumnName;
    @FXML
    private TableColumn<QuestionForms, String> questionformsColumnCreationData;
    @FXML
    private TableColumn<QuestionForms, Number> questionformsColumnNumberOfQuestions;

    @FXML
    private TableView<Votes> showallvotesTable;
    @FXML
    private TableColumn<Votes, Number> showallvotesColumnId;
    @FXML
    private TableColumn<Votes, String> showallvotesColumnName;
    @FXML
    private TableColumn<Votes, String> showallvotesColumnDateFrom;
    @FXML
    private TableColumn<Votes, Number> showallvotesColumnDateTo;
    @FXML
    private TableColumn<Votes, Number> showallvotesColumnSector;
    @FXML
    private TableColumn<Votes, String> showallvotesColumnWho;

    @FXML
    public TabPane tabs;

    /*public ArrayList<Label> peopleArray = new ArrayList<>();
    public ArrayList<Label> questionArray = new ArrayList<>();
    public ArrayList<ComboBox> gradeArray = new ArrayList<>();*/

    public static String voteID;


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
    private void fillVote() throws IOException, SQLException, ClassNotFoundException {

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

        get_type_of_employees();
        try {
            get_all_sectors_names();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void show_all_employes() throws SQLException {
        ResultSet result = Database.execute("SELECT users.id, users.login, users.password, users.firstname,users.lastname,users.type,sectors.name, users.sector_id " +
                "FROM users,sectors where users.sector_id=sectors.id ");
        ObservableList<Users> usersModelData = FXCollections.observableArrayList();
        this.employeeColumnId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        this.employeeColumnName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstname()));
        this.employeeColumnLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastname()));
        this.employeeColumnType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        while (result.next()) {
            usersModelData.add(new Users(result.getInt("id"), result.getString("login"), result.getString("password"),
                    result.getString("firstname"), result.getString("lastname"),
                    result.getString("type"), result.getInt("sector_id")));
        }
        this.employeeTable.setItems(usersModelData);

    }


    @FXML
    private void show_all_sectors() throws SQLException {
        ResultSet result = Database.execute("SELECT * FROM sectors");
        ObservableList<Sectors> sectorsData = FXCollections.observableArrayList();
        this.sectorsColumnId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        this.sectorsColumnName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        //     this.sectorsColumnManager.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getManager()));
        while (result.next()) {
            sectorsData.add(new Sectors(result.getInt("id"), result.getString("name")));
        }
        this.sectorsTable.setItems(sectorsData);
    }

    @FXML
    private void show_all_questionforms() throws SQLException {
        ResultSet result = Database.execute("SELECT * FROM questionforms");
        ObservableList<QuestionForms> questionFormsData = FXCollections.observableArrayList();
        this.questionformsColumnId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        this.questionformsColumnName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        this.questionformsColumnCreationData.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreation_data()));
        this.questionformsColumnNumberOfQuestions.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumber_of_questions()));
        while (result.next()) {
            questionFormsData.add(new QuestionForms(result.getInt("id"), result.getString("name"), result.getString("creation_date"), result.getInt("number_of_questions")));
        }
        this.questionformsTable.setItems(questionFormsData);
    }


    @FXML
    private void show_all_votes() throws SQLException {
        ResultSet result = Database.execute("SELECT *,questionforms.name as questionform_name, sectors.name as sector_name FROM votes,sectors,questionforms WHERE votes.section_id = sectors.id AND votes.questionform_id=questionforms.id");
        ObservableList<Votes> showAllVotesData = FXCollections.observableArrayList();
        this.showallvotesColumnId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        this.showallvotesColumnName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVote_name()));
        this.showallvotesColumnDateFrom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDatatime()));
        this.showallvotesColumnDateTo.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIs_current()));
        this.showallvotesColumnWho.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWho()));
        this.showallvotesColumnSector.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSection_id()));
        while (result.next()) {
/*
            showAllVotesData.add(new Votes(result.getInt("id"), result.getString("vote_name"), result.getString("date_from"), result.getString("date_to") ,result.getString("sector_name")));
*/
            System.out.print(result.getString("id") + " - ");
            System.out.print(result.getString("vote_name") + " - ");
            System.out.print(result.getString("date_from") + " - ");
            System.out.print(result.getString("date_to") + " - ");
            System.out.print(result.getString("who") + " - ");
            System.out.print(result.getString("sector_name") + " - ");
            System.out.println(result.getString("questionform_name"));
        }
//        this.questionformsTable.setItems(showAllVotesData);
    }

    @FXML
    private void show_all_raports() throws SQLException {
        ResultSet result = Database.execute("SELECT * FROM raports,votes where raports.vote_id=votes.id");
        ObservableList<Raports> raportsData = FXCollections.observableArrayList();
        this.raportColumnId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        this.raportColumnName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRaport_name()));
        this.raportColumnDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDatatime()));
        while (result.next()) {
            raportsData.add(new Raports(result.getInt("id"), result.getString("raport_name"), result.getInt("vote_id"),
                    result.getString("date"), result.getString("raport_content")));
        }
        this.raportTable.setItems(raportsData);
    }

    ObservableList<Votes> votesData = FXCollections.observableArrayList();

    @FXML
    private void showGlosujTable() throws SQLException {
        ResultSet result = Database.execute("SELECT * FROM votes");


        this.glosujColumnNumer.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        this.glosujColumnNazwa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVote_name()));

        this.glosujColumnData.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDatatime()));
        this.glosujColumnStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));

        while (result.next()) {
            votesData.add(
                    new Votes(
                            result.getInt("id"),
                            result.getString("vote_name"),
                            result.getString("date_to"),
                            result.getInt("is_current"),
                            result.getString("who"),
                            result.getInt("section_id"),
                            result.getInt("questionform_id")
                    )
            );
        }

        this.glosujTable.setItems(votesData);
    }


    @FXML
    private void add_new_section() throws SQLException, ClassNotFoundException {
        String get_name = new_section_name.getText();
        add_new_sector_message.setText("");
        if (get_name != null && get_name.length() > 1) {
            SectionsFactory.add_new_section(get_name);
            add_new_sector_message.setText("Dodano nowy dział");
        } else {
            add_new_sector_message.setText("Uzupełnij poprawnie dane");
        }

    }

    private void get_type_of_employees() {
       /* ObservableList<String> types =
                FXCollections.observableArrayList(
                        "op1",
                        "opt2"
                );
        select_type = new ComboBox(types);
       */
        select_type.getItems().addAll(
                "kierownik",
                "pracownik"
        );
    }

    private void get_all_sectors_names() throws SQLException {
        ObservableList<String> names = FXCollections.observableArrayList();
        ResultSet result = Database.execute("SELECT * FROM sectors");
        while (result.next()) {
            names.add(result.getString("name"));
        }

        select_sector.setItems(names);
    }

    @FXML
    public void add_new_employee() throws SQLException, ClassNotFoundException {
        String firstname = get_firstname.getText();
        String lastname = get_lastname.getText();
        String type = (String) select_type.getValue();
        String sector = (String) select_sector.getValue();
        add_new_employee_message.setText(" ");

        if (
                firstname != null && firstname.length() > 1 &&
                        lastname != null && lastname.length() > 1 &&
                        type != null && type.length() > 1 &&
                        sector != null && sector.length() > 1
                ) {
            String login = UsersFactory.addNewEmployee(firstname, lastname, type, sector);
            add_new_employee_message.setText("Pomyślnie dodano usera. Login: " + login);
        } else {
            add_new_employee_message.setText("Uzupełnij poprawnie formularz");
        }


    }

    public void getVoteID(MouseEvent mouseEvent) {
        Votes selected_vote = glosujTable.getSelectionModel().getSelectedItem();
        voteID = selected_vote.getId() + "";
    }
}
