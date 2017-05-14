
package sample.database;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import sample.controllers.MainPanelController;

public class UsersFactory extends Model {

    static String currentUserFullName;
    public static String currentUserID;

    public static String login(String log, String pass) throws SQLException, ClassNotFoundException {

        String type = "";

        /*
         * bez zabezpiecznia
         *
       ResultSet result = Database.execute("SELECT `type` FROM `users` WHERE `users`.`login`='" + log + "' AND `users`.`password`='" + pass + "'");

        if (result.first()) {
            //System.out.println(result.getString("type") +" aaaaa");
            type = result.getString("type");
        }*/

        String tab[] = new String[2];
        tab[0] = log;
        tab[1] = pass;
        String sql = "SELECT `type`,`firstname`,`lastname`,`id` FROM `users` WHERE `users`.`login`= ? AND `users`.`password`= ? ";

        ResultSet result = Database.secureExecute(sql, tab);
        if (result.first()) {
            type = result.getString("type");
            currentUserFullName = result.getString("firstname") + " " + result.getString("lastname");
            currentUserID = result.getString("id");
        }
        return type;
    }


    public static String addNewEmployee(String firstname, String lastname, String type, String sector) throws SQLException, ClassNotFoundException {

        // getting id of sector name

        String tab[] = new String[6];

        // create login
        char pom1 = firstname.toCharArray()[0];
        String login = pom1 + lastname;
        // create pass
        String pass = "xxx";
        tab[0] = login;
        tab[1] = pass;
        tab[2] = firstname;
        tab[3] = lastname;
        tab[4] = type;
        tab[5] = null;

        String tab_pom[] = new String[1];
        tab_pom[0] = sector;
        String sql = "SELECT id FROM sectors WHERE name = ?";
        ResultSet result = Database.secureExecute(sql, tab_pom);
        if (result.first()) {
            tab[5] = result.getString("id");
        }

        sql = "INSERT INTO `users` (`id`, `login`, `password`, `firstname`, `lastname`, `type`, `sector_id`) VALUES\n" +
                "(NULL, ?, ?, ?, ?, ?, ?)";

        Database.secureUpdate(sql, tab);
        return login;


    }

    public static ArrayList<Label> getPeopleToFillVote(String voteid) throws SQLException, ClassNotFoundException {
        ArrayList<Label> array = new ArrayList<>();
        String sql = "select users.firstname, users.lastname from votes, users where votes.id=? and votes.section_id=users.sector_id ";
        String tab[] = new String[1];
        tab[0] = voteid;
        ResultSet result = Database.secureExecute(sql, tab);

        while (result.next()) {
            String text = result.getString("firstname") + " " + result.getString("lastname");
            Label person_data = new Label();
            person_data.setText(text);
            person_data.setFont(Font.font(18.00));
            array.add(person_data);
        }
        return array;
    }

    public static String[] getCurrentUserData() throws SQLException {
        String tab[] = new String [3];
        if(currentUserID!=null){
            String sql = "select firstname, lastname, type, name from users, sectors where users.sector_id=sectors.id and users.id="+currentUserID;
            ResultSet result = Database.execute(sql);
            if (result.first()) {
                tab[0] = result.getString("firstname") + " " + result.getString("lastname");
                tab[1] = result.getString("type");
                tab[2] = result.getString("name");
            }


        }
        return tab;
    }

}
