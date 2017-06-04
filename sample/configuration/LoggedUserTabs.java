package sample.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa ustawiania zakladek ktory beda ukryte dla danego uzytkownika
 */
public class LoggedUserTabs 
{
    Map<String, String> map = new HashMap<String, String>();
    
    private static final String [][] tabsToHide = {
        {UserTypes.PRACODAWCA, Tabs.GLOSUJ},
        {UserTypes.KIEROWNIK,  Tabs.DZIALY},
        {UserTypes.PRACOWNIK,  Tabs.PRACOWNICY, Tabs.DZIALY, Tabs.ANKIETY, Tabs.GLOSOWANIE},
    };
    
    private static final String [] defaultTabsToHide = LoggedUserTabs.tabsToHide[2];

    /**
     * przypisuje zakladki
      * @param name stanowisko
     * @return conf konfuguracja zakladek
     */
    public static String[] getTabConfiguration( String name )
    {
        
        for( String[]conf : LoggedUserTabs.tabsToHide){
            if( conf[0].equals(name) ){
                return conf;
            }
        }
        
        return LoggedUserTabs.defaultTabsToHide;
    }
        
}
