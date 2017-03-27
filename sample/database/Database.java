package sample.database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database
{
    private Statement prepareStatement() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        Statement stmt = null;

        DbDetailsProvider dbDetailsProvider = new DbDetailsProvider();
        String user = dbDetailsProvider.getUser();
        String pass = dbDetailsProvider.getPass();
        String host = dbDetailsProvider.getHost();
        
        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection( host, user, pass );
        stmt = (Statement) conn.createStatement( );
        
        return stmt;
    }
    
    public ResultSet execute( String sql ) 
    {
        ResultSet result = null;
        
        try {
            Statement stmt = this.prepareStatement( );
            //TODO jdbc needed
            //result = stmt.executeQuery( sql );
        }
        catch( Exception e ){}
       
        return result;
    }
}
