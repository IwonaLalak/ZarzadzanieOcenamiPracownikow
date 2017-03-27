package sample.database;

public class DbDetailsProvider 
{
    private final String user = "root";
    private final String pass = "";
    private final String host = "jdbc:mysql://localhost/";
    private final String db_name = "";
    
    public String getUser()
    {
        return this.user;
    }
    
    public String getPass()
    {
        return this.pass;
    }
    
    public String getHost()
    {
        return this.host;
    }
    
    public String getDbName()
    {
        return this.db_name;
    }
}
