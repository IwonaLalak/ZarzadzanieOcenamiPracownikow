package sample.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class SectionsFactory extends Model{
    /**
     * dodawanie nowego dzialu
     * @param name nazwa dzialu
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static void add_new_section(String name) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `sectors` (`id`, `name`) VALUES (NULL, ?)";
        String tab[] = new String [1];
        tab[0] = name;
        Database.secureUpdate(sql,tab);

    }

    /**
     * edycja dzialu
     * @param id id dzialu
     * @param name nazwa dzialu
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static void edit_section(String id,String name) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE `sectors` SET `name` = ? WHERE `sectors`.`id` = ?";
        String tab[] = {name, id};
        Database.secureUpdate(sql,tab);
    }

    /**
     * sprawdzanie pracownikow w dziale
     * @param id id
     * @return count_people
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
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

    /**
     * usuwanie dzialu
     * @param id id dzialu
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static void remove_section(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM `sectors` WHERE `sectors`.`id` = ?";
        String tab[] = {id};
        Database.secureUpdate(sql,tab);
    }

}
