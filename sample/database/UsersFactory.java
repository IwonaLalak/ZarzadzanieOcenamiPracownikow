
package sample.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersFactory extends Model {
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
        String sql = "SELECT `type` FROM `users` WHERE `users`.`login`= ? AND `users`.`password`= ? ";

        ResultSet result = Database.secureExecute(sql, tab);
        if (result.first()) {
            type = result.getString("type");
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

        Database.secureUpdate(sql,tab);
        return login;


    }

}
