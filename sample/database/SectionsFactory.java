package sample.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Iwona on 09.04.17.
 */
public class SectionsFactory extends Model{
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

    public static int check_employees_in_sector(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE users.sector_id=?";
        String tab[] = {id};
        ResultSet rs = Database.secureExecute(sql,tab);
        int count_poeple=0;
        while(rs.next()){
            count_poeple++;
        }
        return count_poeple;
    }

    public static void remove_section(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM `sectors` WHERE `sectors`.`id` = ?";
        String tab[] = {id};
        Database.secureUpdate(sql,tab);
    }

}
