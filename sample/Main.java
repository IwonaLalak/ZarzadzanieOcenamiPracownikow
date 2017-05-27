package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.Database;


public class Main extends Application {

    public final static String main = "main";
    public final static String mainView = "views/main_panel.fxml";
    public final static String login = "login";
    public final static String loginView = "views/login.fxml";
    public final static String change_password = "change_password";
    public final static String change_password_View = "views/password_change.fxml";
    public final static String fill_vote = "fill_vote";
    public final static String fill_vote_view = "views/fill_vote.fxml";
    public final static String see_report = "see_report";
    public final static String see_report_view = "views/see_report.fxml";
    public final static String add_question_form = "add_question_form";
    public final static String add_question_form_view = "views/add_question_form.fxml";
    public final static String create_new_vote = "create_new_vote";
    public final static String create_new_vote_view = "views/create_new_vote.fxml";
    public final static String see_question_form = ""
            + "see_question_form";
    public final static String see_question_form_view = "views/see_question_form.fxml";
    public final static String see_vote = "see_vote";
    public final static String see_vote_view = "views/see_vote.fxml";



    @Override
    public void start(Stage primaryStage) throws Exception{

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Main.main,Main.mainView);
        mainContainer.loadScreen(Main.login, Main.loginView);
        mainContainer.loadScreen(Main.change_password, Main.change_password_View);
        mainContainer.loadScreen(Main.see_report, Main.see_report_view);
        mainContainer.loadScreen(Main.fill_vote, Main.fill_vote_view);
        mainContainer.loadScreen(Main.add_question_form, Main.add_question_form_view);
        mainContainer.loadScreen(Main.create_new_vote, Main.create_new_vote_view);
        mainContainer.loadScreen(Main.see_question_form, Main.see_question_form_view);
        mainContainer.loadScreen(Main.see_vote, Main.see_vote_view);

        mainContainer.setScreen(Main.login);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root,800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("System zarządzania pracownikami");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
