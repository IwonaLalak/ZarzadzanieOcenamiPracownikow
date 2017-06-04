package sample.database;


import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class RaportsFactory extends Model {

    public RaportsFactory(String tableName){
        super(tableName);
    }

    /**
     * wstawianie reportow
     * @param vote_id id glosowania
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException  Rzuca, gdy aplikacja nie może znaleźć klasy
     */
    public static void insertReport(String vote_id) throws SQLException, ClassNotFoundException {

        // getting logs
        String logs = "";

        String sql = "select log_short from logs where vote_id=?";
        String pom[] = {vote_id};
        ResultSet rs = Database.secureExecute(sql,pom);
        while(rs.next()){
            logs+=rs.getString("log_short")+"<br/>";
        }

        // get vote name

        String name = "";
        sql = "select vote_name from votes where votes.id=?";
        rs = Database.secureExecute(sql,pom);
        if(rs.first()){
            name = "Raport z: "+rs.getString("vote_name");
        }

        // insert

        sql = "INSERT INTO `raports` (`id`, `raport_name`, `vote_id`, `date`, `raport_content`) VALUES (NULL, ?, ?, CURRENT_TIMESTAMP, ?)";
        String tab[] = {name,vote_id,logs};
        Database.secureUpdate(sql,tab);


    }

}

