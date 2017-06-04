
package sample.database;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import sample.controllers.MainPanelController;
import sample.configuration.UserTypes;

public class UsersFactory extends Model {

    static String currentUserFullName;
    public static String currentUserID;

    /**
     * logowanie do systemu
     * @param log login
     * @param pass haslo
     * @return type
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static String login(String log, String pass) throws SQLException, ClassNotFoundException {
        String type = "";

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

    /**
     * dodawanie nowego pracownika
     * @param firstname imie
     * @param lastname nazwisko
     * @param email email
     * @param type stanowisko
     * @param sector dzial
     * @return login
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static String addNewEmployee(String firstname, String lastname, String email, String type, String sector) throws SQLException, ClassNotFoundException {

        // getting id of sector name

        String tab[] = new String[7];

        // create login
        char pom1 = firstname.toCharArray()[0];
        String login = pom1 + lastname;
        // create pass
        String pass = "xxx";
        tab[0] = login;
        tab[1] = email;
        tab[2] = pass;
        tab[3] = firstname;
        tab[4] = lastname;
        tab[5] = type;
        tab[6] = null;

        String tab_pom[] = new String[1];
        tab_pom[0] = sector;
        String sql = "SELECT id FROM sectors WHERE name = ?";
        ResultSet result = Database.secureExecute(sql, tab_pom);
        if (result.first()) {
            tab[6] = result.getString("id");
        }

        sql = "INSERT INTO `users` (`id`, `login`, `email`, `password`, `firstname`, `lastname`, `type`, `sector_id`) VALUES\n" +
                "(NULL, ?, ?, ?, ?, ?, ?, ?)";

        Database.secureUpdate(sql, tab);
        return login;
    }

    /**
     * edycja pracownika
     * @param id id
     * @param email email
     * @param type stanowisko
     * @param sector dzial
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static void edit_employee(String id, String email, String type, String sector) throws SQLException, ClassNotFoundException {

        String tab[] = {email, type, sector, id};

        String tab_pom[] = {sector};
        String sql = "SELECT id FROM sectors WHERE name = ?";
        ResultSet result = Database.secureExecute(sql, tab_pom);
        if (result.first()) {
            tab[2] = result.getString("id");
        }

        sql = "UPDATE `users` SET `email` = ?, `type` = ?, `sector_id` = ? WHERE `users`.`id` = ? ";
        Database.secureUpdate(sql, tab);
    }

    /**
     * pobieranie uzytkownikow do glosowania
     * @param voteid id glosowania
     * @return array
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
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

    /**
     * pobieranie danych uzytkownika
     * @return tab
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     */
    public static String[] getCurrentUserData() throws SQLException {
        String tab[] = new String[3];
        if (currentUserID != null) {
            String sql = "select firstname, lastname, type, name from users, sectors where users.sector_id=sectors.id and users.id=" + currentUserID;
            ResultSet result = Database.execute(sql);
            if (result.first()) {
                tab[0] = result.getString("firstname") + " " + result.getString("lastname");
                tab[1] = result.getString("type");
                tab[2] = result.getString("name");
            }


        }
        return tab;
    }

    /**
     * otrzymywanie emaili
     * @return emails
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static String[] getEmployeeUsersEmails() throws SQLException, ClassNotFoundException {
        LinkedList<String> getEmails = new LinkedList<>();
        try {
            ResultSet result = Database.secureExecute("SELECT email FROM users where type = ?", new String[]{UserTypes.PRACOWNIK});
            while (result.next()) {
                getEmails.push(result.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print("Problem with SQL Statement" + e.getStackTrace());
        } catch (ClassNotFoundException e) {
            System.out.print("Problem with ClassNotFound" + e.getStackTrace());
        }
        String[] emails = new String[getEmails.size()];
        for (int i = 0; i < getEmails.size(); i++) {
            emails[i] = getEmails.get(i);
        }
        return emails;
    }

    /**
     * usuwanie pracownika
     * @param id id pracownika
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static void remove_employee(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM `users` WHERE `users`.`id` = ?";
        String tab[] = {id};
        Database.secureUpdate(sql, tab);
    }


}
