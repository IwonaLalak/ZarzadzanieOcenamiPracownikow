
package sample.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users extends Model {
    public static String login(String log, String pass) throws SQLException, ClassNotFoundException {

        String type = "";

        /*
        * String query = "SELECT account_balance FROM user_data WHERE user_name = ? ";

 PreparedStatement pstmt = connection.prepareStatement( query );
 pstmt.setString( 1, custname);
        * */

/*
        String query = "SELECT `type` FROM `users` WHERE `users`.`login`= ? AND `users`.`password`= ? ";

        Connection conn = Database.prepareConn();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1,log);
        pstmt.setString(2,pass);
        ResultSet result = result.executeQuery(query);
*/
        // TODO: trzeba raczej przerobić metody w klasie database
        ResultSet result = Database.execute("SELECT `type` FROM `users` WHERE `users`.`login`='" + log + "' AND `users`.`password`='" + pass + "'");

        if (result.first()) {
            //System.out.println(result.getString("type") +" aaaaa");
            type = result.getString("type");
        }

        return type;
    }

}
