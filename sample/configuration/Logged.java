package sample.configuration;

public class Logged 
{
    public static String WHO;
    public static String username;
    
    public static String whoIsLogged()
    {
        return Logged.WHO;
    }
    
    public static void setWho( String name )
    {
        if( name.equals(UserTypes.KIEROWNIK) || name.equals(UserTypes.PRACOWNIK) || name.equals(UserTypes.PRACODAWCA)){
            Logged.WHO = name;
        }
    }
    
    public static void setUsername( String name )
    {
        Logged.username = name;
    }
}
