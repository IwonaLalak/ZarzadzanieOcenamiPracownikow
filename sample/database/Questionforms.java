package sample.database;

import javafx.scene.control.TextField;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Iwona on 09.04.17.
 */
public class Questionforms extends Model{

    public static void add_new_questionform(String name, ArrayList<TextField> questions) throws SQLException, ClassNotFoundException {


        // check na konsole
        System.out.println("name: "+name);

        for(int i=0;i<questions.size();i++){
            System.out.println("q: "+questions.get(i).getText());
        }

        // pierw insertujemy ankiete
        String sql = "INSERT INTO `questionforms` (`id`, `name`,`creation_date`,`number_of_questions`) VALUES (NULL, ?, CURRENT_TIMESTAMP, ?)";
        String tab[] = new String[2];
        tab[0] = name;
        tab[1] = questions.size()+"";

        Database.secureUpdate(sql,tab);


        // gdy mamy id ankiety mozemy insertowac pytania

        String id_of_new_qf = null;
        sql = "SELECT id FROM questionforms WHERE name=?";
        tab= new String[1];
        tab[0] = name;
        ResultSet result = Database.secureExecute(sql,tab);
        if(result.first()){
            //pobieramy idka
            id_of_new_qf = result.getString("id");
        }
        if(id_of_new_qf!=null){
            for(int i=0;i<questions.size();i++){
                sql = "INSERT INTO `questions` (`id`, `content`,`questionform_id`) VALUES (NULL, ?, "+id_of_new_qf+")";
                tab[0] = questions.get(i).getText();
                Database.secureUpdate(sql,tab);
            }

        }


    }

}
