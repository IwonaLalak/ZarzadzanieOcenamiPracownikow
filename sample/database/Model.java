package sample.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
    
    /**
     * Zwraca wszystkie rekordy z bazy
     * @return ResultSet
     */
    public static ResultSet all()
    {
        String tableName = Model.getClassNameFromStatic();
        String sql = "SELECT * FROM " + tableName;
        
        return Model.execute( sql );
    }
    
    /**
     * Zwraca tylko pierwszy rekord z bazy
     * @return ResultSet
     */
    public static ResultSet first()
    {
        String tableName = Model.getClassNameFromStatic();
        String sql = "SELECT * FROM " + tableName + " LIMIT 1";
        
        return Model.execute( sql );
    }
    
    /**
     * Szuka rekordu o podanym id
     * @return ResultSet
     */
    public static ResultSet find( String id )
    {
        String tableName = Model.getClassNameFromStatic();
        String sql = "Select * FROM " + tableName + " WHERE id = " + id;
        
        return Model.execute( sql );
    }
    
    /**
     * Zapisuje lub robi update
     * @return boolean
     */
    public boolean save()
    {
        //TODO
        
        return false;
    }
    
    /**
     * Zwraca nazwe klasy 
     * @return 
     */
    public static String getClassNameFromStatic()
    {
        return Thread.currentThread().getStackTrace()[1].getClassName();
    }
    
    /**
     * Wykonuje SQL query
     * @param sql
     * @return 
     */
    private static ResultSet execute( String sql ) 
    {
        Database db = new Database();
        
        ResultSet rs = null;
        
        try {
            rs = db.execute( sql );
        }
        catch( Exception e ){
            //TODO
        }
        
        return rs;
    }
    
}
