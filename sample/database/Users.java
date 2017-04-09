
package sample.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users extends Model {
    public static String login(String log, String pass) throws SQLException {

        String type = "";


        ResultSet result = Database.execute("SELECT `type` FROM `users` WHERE `users`.`login`='" + log + "' AND `users`.`password`='" + pass + "'");
        if (result.first()) {
            //System.out.println(result.getString("type") +" aaaaa");
            type = result.getString("type");
        }

        return type;
    }

}
