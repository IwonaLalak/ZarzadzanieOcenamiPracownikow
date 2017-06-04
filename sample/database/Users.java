
package sample.database;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Users extends Model {
    /**
     * pobieranie id przez uzytkowniak
     * @param username nazwa uzytkownika
     * @return 0
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public int getIdByUsername(String username) throws SQLException, ClassNotFoundException {
        String[] params = {username};

        ResultSet result = Database.secureExecute("SELECT id FROM Users where login = ?", params);
        if (result.first()) {
            return result.getInt("id");
        }

        return 0;
    }
}
