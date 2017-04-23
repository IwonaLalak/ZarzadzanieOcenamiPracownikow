package sample.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Kamil
 * W arrayach wrzucamy zakladki ktore chcemy ukryć dla danego usera
 */
public class LoggedUserTabs 
{
    Map<String, String> map = new HashMap<String, String>();
    
    private static final String [][] tabsToHide = {
        {UserTypes.PRACODAWCA, Tabs.GŁOSUJ},
        {UserTypes.KIEROWNIK,  Tabs.DZIAŁY},
        {UserTypes.PRACOWNIK,  Tabs.PRACOWNICY, Tabs.DZIAŁY, Tabs.ANKIETY, Tabs.GŁOSOWANIE},
    };
    
    private static final String [] defaultTabsToHide = LoggedUserTabs.tabsToHide[2];
    
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
