package sample.database.entity;

/*
@Entity
@Table( name = "Logs" )*/
/**
 * klasa logow z glosowan
 */
public class Logs {

    private int id;
    private int vote_id;
    private int user_id;
    private String datatime;
    private String log_content;
    private String log_short;

    public Logs(int id, int vote_id, int user_id, String datatime, String log_content, String log_short){
        this.id = id;
        this.vote_id = vote_id;
        this.user_id = user_id;
        this.datatime = datatime;
        this.log_content = log_content;
        this.log_short = log_short;
    }

    public Logs(String log_content){
        this.log_content=log_content;
    }

    public Logs(){
    }
    /**
     * pobieranie identyfikatora
     * @return  id
     */
    public int getId() {
        return id;
    }

    /**
     * przypisywanie identyfikatora
     * @param id identyfikator
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     *pobiera id dla danego glosowania
     *@return vote_id
     */
    public int getVote_id() {
        return vote_id;
    }
    /**
     * przypisywanie id dla danego glosowania
     * @param vote_id id dla glosowania
     */
    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }
    /**
     * pobiera id uzytkowanika
     * @return user_id
     */
    public int getUser_id() {
        return user_id;
    }
    /**
     * przypisywanie id uzytkownika
     * @param user_id id uzytkownika
     */

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    /**
     * pobieranie daty danego logu
     * @return datatime
     */
    public String getDatatime() {
        return datatime;
    }
    /**
     * przypisywanie daty danego logu
     * @param datatime data logu
     */

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }
    /**
     * pobieranie zawartosci logu
     * @return log_concent
     */
    public String getLog_content() {
        return log_content;
    }
    /**
     * przypisywanie zawartosci logu
     * @param log_content zawartosc logu
     */
    public void setLog_content(String log_content) {
        this.log_content = log_content;
    }
    /**
     * ??
     * @return  log_short
     */
    public String getLog_short() {
        return log_short;
    }

    /**
     * ??
     * @param log_short ??
     */
    public void setLog_short(String log_short) {
        this.log_short = log_short;
    }
}
