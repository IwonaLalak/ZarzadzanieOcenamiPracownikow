package sample.configuration;

/**
 * Klasa do sprawdzania kto jest zalogowany do aplikacji
 */
public class Logged 
{
    /**
     * z jakiego stanowiska zalogowano sie do aplikacji
     */
    public static String WHO;
    /**
     * kto  sie zalogowal
     */
    public static String username;

    /**
     * kto jest zalogowany
     * @return Logged.WHO
     */
    public static String whoIsLogged()
    {
        return Logged.WHO;
    }

    /**
     * z jakiego stanowiska nastapilo logowanie
     * @param name name
     */
    public static void setWho( String name )
    {
        if( name.equals(UserTypes.KIEROWNIK) || name.equals(UserTypes.PRACOWNIK) || name.equals(UserTypes.PRACODAWCA)){
            Logged.WHO = name;
        }
    }

    /**
     * odczytanie kto sie zalogowal
     * @param name name
     */
    public static void setUsername( String name )
    {
        Logged.username = name;
    }
}
