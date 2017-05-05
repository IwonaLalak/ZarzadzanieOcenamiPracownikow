
package sample.database;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Users extends Model {

    public int getIdByUsername(String username) throws SQLException, ClassNotFoundException {
        String[] params = {username};

        ResultSet result = Database.secureExecute("SELECT id FROM Users where login = ?", params);
        if (result.first()) {
            return result.getInt("id");
        }

        return 0;
    }
}
