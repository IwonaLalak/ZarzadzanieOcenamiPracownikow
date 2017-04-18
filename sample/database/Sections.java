package sample.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Iwona on 09.04.17.
 */
public class Sections extends Model{
    public static void add_new_section(String name) throws SQLException, ClassNotFoundException {
        /*
        * bez zabezpieczenia
        *
        Database.update("INSERT INTO `sectors` (`id`, `name`) VALUES (NULL, '"+name+"')");
        */

        String sql = "INSERT INTO `sectors` (`id`, `name`) VALUES (NULL, ?)";
        String tab[] = new String [1];
        tab[0] = name;
        Database.secureUpdate(sql,tab);

    }

}
