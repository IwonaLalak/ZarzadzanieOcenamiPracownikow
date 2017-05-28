package sample.database;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Iwona on 09.04.17.
 */
public class QuestionFormsFactory extends Model {

    public static void add_new_questionform(String name, ArrayList<TextField> questions) throws SQLException, ClassNotFoundException {


        // check na konsole
        System.out.println("name: " + name);

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("q: " + questions.get(i).getText());
        }

        // pierw insertujemy ankiete
        String sql = "INSERT INTO `questionforms` (`id`, `name`,`creation_date`,`number_of_questions`) VALUES (NULL, ?, CURRENT_TIMESTAMP, ?)";
        String tab[] = new String[2];
        tab[0] = name;
        tab[1] = questions.size() + "";

        Database.secureUpdate(sql, tab);


        // gdy mamy id ankiety mozemy insertowac pytania

        String id_of_new_qf = null;
        sql = "SELECT id FROM questionforms WHERE name=?";
        tab = new String[1];
        tab[0] = name;
        ResultSet result = Database.secureExecute(sql, tab);
        if (result.first()) {
            //pobieramy idka
            id_of_new_qf = result.getString("id");
        }
        if (id_of_new_qf != null) {
            for (int i = 0; i < questions.size(); i++) {
                sql = "INSERT INTO `questions` (`id`, `content`,`questionform_id`) VALUES (NULL, ?, " + id_of_new_qf + ")";
                tab[0] = questions.get(i).getText();
                Database.secureUpdate(sql, tab);
            }

        }


    }

    public static ArrayList<Label> getQuestionsToFillVote(String voteid) throws SQLException, ClassNotFoundException {
        ArrayList<Label> array = new ArrayList<>();
        String sql = "select questions.content from questions, votes where votes.id=? and questions.questionform_id=votes.questionform_id";
        String tab[] = new String[1];
        tab[0] = voteid;
        ResultSet result = Database.secureExecute(sql, tab);
        while (result.next()) {
            Label question_data = new Label();
            question_data.setText(result.getString("content"));
            array.add(question_data);
        }
        return array;
    }

    public static void remove_questionform(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM `questionforms` WHERE `questionforms`.`id` = ?";
        String tab[] = {id};
        Database.secureUpdate(sql,tab);
    }

    public static String[] getQuestionformData(String id) throws SQLException, ClassNotFoundException {
        String data[] = new String [4];
        String sql = "SELECT * FROM questionforms WHERE id=?";
        String tab[] = {id};
        ResultSet rs = Database.secureExecute(sql,tab);
        if(rs.first()){
            data[0] = id;
            data[1] = rs.getString("name");
            data[2] = rs.getString("creation_date");
            data[3] = rs.getString("number_of_questions");
        }

        return data;
    }

    public static ArrayList<String> getQuestionform_questions(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions WHERE questionform_id=?";
        String tab[] = {id};
        ResultSet rs = Database.secureExecute(sql,tab);
        while(rs.next()){
            questions.add(rs.getString("content"));
        }

        return questions;
    }

}
