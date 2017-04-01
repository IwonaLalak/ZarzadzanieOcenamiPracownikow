package sample.database;

import java.sql.*;

public class Database
{
    public static Statement  prepareStatement() throws ClassNotFoundException, SQLException
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
    
    public static ResultSet execute( String sql ) 
    {
        System.out.println(sql);
        ResultSet result = null;
        
        try {
            Statement stmt = Database.prepareStatement( );
            
            result = stmt.executeQuery( sql );
        }
        catch( Exception e ){
            System.out.println( e.getMessage() );
        }
       
        return result;
    }
    
    public static void update( String sql )
    {
        System.out.println(sql);
        try {
            Statement stmt = Database.prepareStatement( );
            
            stmt.executeUpdate( sql );
        }
        catch( Exception e ){
            System.out.println( e.getMessage() );
        }
       
    }
}
