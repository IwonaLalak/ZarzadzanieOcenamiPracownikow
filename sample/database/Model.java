package sample.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model 
{
    /**
     * index: nazwa kolumny z Db
     * value: wartosc z danej kolumny
     * np. name:Kamil
     */
    HashMap data = new HashMap();
    
    public Model() 
    {
        String sql = "SELECT * FROM " + this.getTableName();
        ResultSet rs = Database.execute( sql );
        ResultSetMetaData rsmd;
        
        try {
            rsmd = rs.getMetaData();
            
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++ ) {
                String columnName = rsmd.getColumnName(i);
                this.data.put( columnName, "" );
            }
            
            Set set = data.entrySet();
            Iterator i = set.iterator();
            while(i.hasNext()) {
               Map.Entry me = (Map.Entry)i.next();
            }
      
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Zwraca wszystkie rekordy z bazy
     * @return ResultSet
     */
    public ResultSet all()
    {   
        String tableName = this.getTableName();
        String sql = "SELECT * FROM " + tableName;
        
        return Database.execute( sql );
    }
    
    /**
     * Zwraca tylko pierwszy rekord z bazy
     * @return ResultSet
     */
    public ResultSet first()
    {
        String tableName = this.getTableName();
        String sql = "SELECT * FROM " + tableName + " LIMIT 1";
        
        return Database.execute( sql );
    }
    
    /**
     * Szuka rekordu o podanym id
     * @return ResultSet
     */
    public Model find( String id )
    {
        String tableName = this.getTableName();
        String sql = "Select * FROM " + tableName + " WHERE id = " + id;
        
        ResultSet result = Database.execute( sql );
        try {
            while( result.next() ){
                ResultSetMetaData rsmd = result.getMetaData();
            
                int columnCount = rsmd.getColumnCount();

                for (int i = 1; i <= columnCount; i++ ) {
                    String columnName = rsmd.getColumnName(i);
                    this.data.put( columnName, result.getString(i) );
                }

            }
        }
        catch( Exception e){
            System.out.println( e.getMessage() );
        }
       
        return this;
    }
    
    public void set( String key, String value )
    {   
        this.data.put( key, value);
    }
    
    public String get( String key )
    {
        return this.data.get( key ).toString();
    }
    
    /**
     * Zapisuje lub robi update
     * @return boolean
     */
    public boolean save()
    {
        if( this.data.get("id") == ""){
            return this.insert();
        }
       
        Set set = this.data.entrySet();
        Iterator i = set.iterator();
        
        String sql = "UPDATE `" + this.getTableName() + "` SET ";
                
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            
            sql += "`" + me.getKey() + "`='" + me.getValue() + "' ";
            
            if(i.hasNext()){
               sql += ",";
            }
        }
        sql += "WHERE `id`='" + this.data.get( "id" ) + "'";
       
        
        Database.update( sql );
        
        return true;
    }
    
    public boolean insert()
    {
        Set set = this.data.entrySet();
        Iterator i = set.iterator();
        
        String sql = "INSERT INTO `" + this.getTableName() + "` ( ";
        String values = " VALUES( ";
        while (i.hasNext()) {
            
            Map.Entry me = (Map.Entry) i.next();
            if(me.getKey().equals("id") ){
                continue;
            }
            sql += "`" + me.getKey() + "`";
            values += "'" + me.getValue() + "' ";
            if( i.hasNext() ){
               sql += ",";
               values += ",";
            }
        }
        
        values += " )";
        sql +=  ")" + values;
        
        
        Database.update( sql );
        
        return true;
    }
    
    public String getTableName()
    {
        return this.getClass().getSimpleName();
    }
    
    public void printModelData() {
        Set set = this.data.entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}
