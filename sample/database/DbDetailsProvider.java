package sample.database;

public class DbDetailsProvider 
{
    /**
     * nazwa uzytkownika bazy danych
     */
    private final String user = "root";
    /**
     * haslo uzytkownika bazy danych
     */
    private final String pass = "";
    /**
     * host bazy danychh
     */
    private final String host = "jdbc:mysql://localhost/";
    /**
     * nazwa bazy dancyh
     */
    private final String db_name = "zarzadzanie_pracownikami";

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
        return this.host +""+ this.db_name;
    }
    
    public String getDbName()
    {
        return this.db_name;
    }
}
