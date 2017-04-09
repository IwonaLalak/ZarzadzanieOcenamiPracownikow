package sample.configuration;

/**
 * 
 * @author Kamil
 * W arrayach wrzucamy zakladki ktore chcemy ukryć dla danego usera
 */
public class LoggedUserTabs 
{

    // dodac final, duzymi literami nazwa
    public static String [] pracodawca = { "Głosuj" };
    
    public static String [] kierownik = { "Działy" };
    
    public static String [] pracownik = { "Pracownicy", "Działy", "Ankiety", "Głosowanie" };
    
    public static String[] getTabConfiguration( String name )
    {
        if( name.equals("pracodawca") ){
            return LoggedUserTabs.pracodawca;
        }
        else if ( name.equals("kierownik") ){
            return LoggedUserTabs.kierownik;
        }
       
        return LoggedUserTabs.pracownik;
    }
}
