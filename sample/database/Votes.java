package sample.database;


import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Iwona on 09.04.17.
 */
public class Votes extends Model{

    public static void add_new_vote(String vote_name, LocalDate enddate, String sector_name, String who_can_vote, String qf_name ) throws SQLException, ClassNotFoundException {


        String sql = "INSERT INTO `votes` (`id`, `vote_name`, `date_from`, `date_to`, `is_current`, `who`, `section_id`, `questionform_id`) VALUES (NULL, ?, CURRENT_TIMESTAMP, ?, '1', ?, ?, ?)";
        String tab[] = new String[5];
        tab[0] = vote_name ; //nazwa glosowania
        tab[1] = enddate+" 00:00:00"; // data zakonczenia
        tab[2] = ""; // kto moze glosowac - to ponizej
        tab[3] = ""; // jaki dzial
        tab[4] = ""; // jaka ankieta

        // pobranie id ankiety po nazwie
        String sql_pom = "SELECT id FROM questionforms where name=?";
        String tab_pom[] = new String[1];
        tab_pom[0] = qf_name;
        ResultSet result = Database.secureExecute(sql_pom,tab_pom);
        if(result.first()){
            tab[4]=result.getString("id");
        }

        // pobranie id dzialu po nazwie
        sql_pom = "SELECT id FROM sectors where name=?";
        tab_pom[0] = sector_name;
        result = Database.secureExecute(sql_pom,tab_pom);
        if(result.first()){
            tab[3]=result.getString("id");
        }

        // w zaleznosci od tego kto moze glosowac
        // pracownicy i kierownicy
        if(Objects.equals(who_can_vote, "kierownicy i pracownicy")){
            // tutaj poleca dwa inserty

            //najpierw pracownik
            tab[2] = "pracownik";
            Database.secureUpdate(sql,tab);

            //potem kierownik
            tab[2] = "kierownik";
            Database.secureUpdate(sql,tab);

        }
        // tylko pracownicy lub tylko kierownicy
        else{
            // jeden insert
            if(Objects.equals(who_can_vote, "tylko kierownicy")){
                tab[2] = "kierownik";
            }
            else{
                tab[2] = "pracownik";
            }

            Database.secureUpdate(sql,tab);

        }

    }

}
