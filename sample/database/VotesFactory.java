package sample.database;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.controllers.FillVoteController;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Iwona on 09.04.17.
 */
public class VotesFactory extends Model {

    public VotesFactory(String tableName){
        super(tableName);
    }
    
    public static void add_new_vote(String vote_name, LocalDate enddate, String sector_name, String who_can_vote, String qf_name) throws SQLException, ClassNotFoundException {


        String sql = "INSERT INTO `votes` (`id`, `vote_name`, `date_from`, `date_to`, `is_current`, `who`, `section_id`, `questionform_id`) VALUES (NULL, ?, CURRENT_TIMESTAMP, ?, '1', ?, ?, ?)";
        String tab[] = new String[5];
        tab[0] = vote_name; //nazwa glosowania
        tab[1] = enddate + " 00:00:00"; // data zakonczenia
        tab[2] = ""; // kto moze glosowac - to ponizej
        tab[3] = ""; // jaki dzial
        tab[4] = ""; // jaka ankieta

        // pobranie id ankiety po nazwie
        String sql_pom = "SELECT id FROM questionforms where name=?";
        String tab_pom[] = new String[1];
        tab_pom[0] = qf_name;
        ResultSet result = Database.secureExecute(sql_pom, tab_pom);
        if (result.first()) {
            tab[4] = result.getString("id");
        }

        // pobranie id dzialu po nazwie
        sql_pom = "SELECT id FROM sectors where name=?";
        tab_pom[0] = sector_name;
        result = Database.secureExecute(sql_pom, tab_pom);
        if (result.first()) {
            tab[3] = result.getString("id");
        }

        // w zaleznosci od tego kto moze glosowac
        // pracownicy i kierownicy
        if (Objects.equals(who_can_vote, "kierownicy i pracownicy")) {
            // tutaj poleca dwa inserty

            //najpierw pracownik
            tab[2] = "pracownik";
            Database.secureUpdate(sql, tab);

            //potem kierownik
            tab[2] = "kierownik";
            Database.secureUpdate(sql, tab);

        }
        // tylko pracownicy lub tylko kierownicy
        else {
            // jeden insert
            if (Objects.equals(who_can_vote, "tylko kierownicy")) {
                tab[2] = "kierownik";
            } else {
                tab[2] = "pracownik";
            }

            Database.secureUpdate(sql, tab);

        }


        //najpierw pobrac liste ludzi uprawnionych  do glosowania
        ArrayList<String> users_who_will_vote = new ArrayList<>();
        String userssql = "select id from users where users.type=? and users.sector_id=?";
        String params[] = {"", tab[3]};
        ResultSet res;
        if (Objects.equals(who_can_vote, "kierownicy i pracownicy")) {

            params[0] = "pracownik";
            res = Database.secureExecute(userssql, params);
            while (res.next()) {
                users_who_will_vote.add(res.getString("id"));
            }

            String votessql = "SELECT id from votes where votes.vote_name=?";
            String v_name[] = {vote_name};
            String vote_id = "";

            ResultSet v_res = Database.secureExecute(votessql, v_name);
            if (v_res.first()) {
                vote_id = v_res.getString("id");
            }

            String fillsql = "INSERT INTO `user_fill_vote` (`id`, `user_id`, `vote_id`, `filled`) VALUES (NULL, ?, ?, '0')";
            String fill[] = {"", vote_id};

            for (int i = 0; i < users_who_will_vote.size(); i++) {
                //System.out.println("ins: " + users_who_will_vote.get(i) + vote_id);
                fill[0] = users_who_will_vote.get(i);
                Database.secureUpdate(fillsql, fill);
            }


            users_who_will_vote.clear();

            params[0] = "kierownik";

            res = Database.secureExecute(userssql, params);
            while (res.next()) {
                users_who_will_vote.add(res.getString("id"));
            }

            votessql = "SELECT id from votes where votes.vote_name=?";
            vote_id = "";

            v_res = Database.secureExecute(votessql, v_name);
            if (v_res.last()) {
                vote_id = v_res.getString("id");
            }

            fillsql = "INSERT INTO `user_fill_vote` (`id`, `user_id`, `vote_id`, `filled`) VALUES (NULL, ?, ?, '0')";
            fill[1] = vote_id;

            for (int i = 0; i < users_who_will_vote.size(); i++) {
                //System.out.println("ins: " + users_who_will_vote.get(i) + vote_id);
                fill[0] = users_who_will_vote.get(i);
                Database.secureUpdate(fillsql, fill);
            }

        }
        // tylko pracownicy lub tylko kierownicy
        else {
            if (Objects.equals(who_can_vote, "tylko kierownicy")) {
                params[0] = "kierownik";
            } else {
                params[0] = "pracownik";
            }

            res = Database.secureExecute(userssql, params);
            while (res.next()) {
                users_who_will_vote.add(res.getString("id"));
            }

            userssql = "SELECT id from votes where votes.vote_name=?";
            String v_name[] = {vote_name};
            String vote_id = "";

            res = Database.secureExecute(userssql, v_name);
            if (res.first()) {
                vote_id = res.getString("id");
            }

            String fillsql = "INSERT INTO `user_fill_vote` (`id`, `user_id`, `vote_id`, `filled`) VALUES (NULL, ?, ?, '0')";
            String fill[] = {"", vote_id};

            for (int i = 0; i < users_who_will_vote.size(); i++) {
                //System.out.println("ins: " + users_who_will_vote.get(i) + vote_id);
                fill[0] = users_who_will_vote.get(i);
                Database.secureUpdate(fillsql, fill);
            }

        }


    }

    public static void send_your_vote(String indx, String grade, ArrayList<Label> people, ArrayList<Label> questions, String voteID) throws SQLException, ClassNotFoundException {

        //przerobienie wprowadzonych danych do postaci: oceniany;ocena;pytanie
        String employee_id;
        String question_id;

        char tab[] = indx.toCharArray();
        // gdy pracownikow <10 i pytan <10
        if (indx.length() == 17) {
            employee_id = tab[6] + "";
            question_id = tab[16] + "";
        } // gdy pracownikow <10 i pytan >10
        else if (indx.length() == 18 && tab[7] == ';') {
            employee_id = tab[6] + "";
            question_id = tab[16] + tab[17] + "";
        }// gdy pracownikow >10 i pytan <10
        else if (indx.length() == 18 && tab[8] == ';') {
            employee_id = tab[6] + tab[7] + "";
            question_id = tab[17] + "";
        }//gdy pracownikow>10 i pytan >10
        else { // lenght 19
            employee_id = tab[6] + tab[7] + "";
            question_id = tab[17] + tab[18] + "";
        }

        String log_short = people.get(Integer.parseInt(employee_id)).getText() + ";" + grade + ";" + questions.get(Integer.parseInt(question_id)).getText();
        /*System.out.println("-----");
        System.out.println("oceniany: "+employee_id +" "+ people.get(Integer.parseInt(employee_id)).getText());
        System.out.println("ocena: "+grade);
        System.out.println("pytanie: "+question_id+" "+questions.get(Integer.parseInt(question_id)).getText());*/

        String log_content = "Uzytkownik " + UsersFactory.currentUserFullName + " ocenil " + people.get(Integer.parseInt(employee_id)).getText() + " na ocene " + grade + " w pytaniu " + questions.get(Integer.parseInt(question_id)).getText();

        // insert oceny do logow
        String sql = "INSERT INTO `logs` (`id`, `vote_id`, `user_id`, `date`, `log_content`, `log_short`, `rated_person`, `grade`, `on_question`) VALUES (NULL, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?, ?, ?)";

        String param[] = new String[7];
        param[0] = voteID;
        param[1] = UsersFactory.currentUserID;
        param[2] = log_content;
        param[3] = log_short;
        param[4] = people.get(Integer.parseInt(employee_id)).getText();
        param[5] = grade;
        param[6] = questions.get(Integer.parseInt(question_id)).getText();
        //System.out.println("wysylanie: "+param[0]+" "+param[1]+" "+param[2]+" "+param[3]+" ");
        Database.secureUpdate(sql, param);

    }

    public static void select_that_user_voted(String voteID) throws SQLException, ClassNotFoundException {

        // dane sa wyciagane z bazy, a nie insertowane wiec mozna przez zwykly update (na secureUpdate nie dziala)
        String sql = "UPDATE `user_fill_vote` SET `filled` = '1' WHERE `user_fill_vote`.`vote_id` = " + voteID + " AND `user_fill_vote`.`user_id` = " + UsersFactory.currentUserID;
        Database.update(sql);
    }

}

