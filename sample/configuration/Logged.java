package sample.configuration;

public class Logged 
{
    public static String WHO;
    
    public static String whoIsLogged()
    {
        return Logged.WHO;
    }
    
    public static void setWho( String name )
    {
        Logged.WHO = name;
    }
}
