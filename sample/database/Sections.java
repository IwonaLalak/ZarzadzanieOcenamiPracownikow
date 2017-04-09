package sample.database;

/**
 * Created by Iwona on 09.04.17.
 */
public class Sections extends Model{
    public static void add_new_section(String name){
        // TODO: jest bez zabezpieczenia
        Database.update("INSERT INTO `sectors` (`id`, `name`) VALUES (NULL, '"+name+"')");
    }
}
