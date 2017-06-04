package sample.database.entity;
/**
 * klasa raportow
 */
public class Raports {

    private Integer id;
    private String raport_name;
    private Integer vote_id;
    private String datatime;
    private String raport_content;

    public Raports(int id, String raport_name, int vote_id, String datatime, String raport_content) {
        this.id = id;
        this.raport_name = raport_name;
        this.vote_id = vote_id;
        this.datatime = datatime;
        this.raport_content = raport_content;
    }
    /**
     * pobieranie id raportu
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * przypisanie id do raportu
     * @param id id raportu
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * pobieranie nazwy raportu
     * @return report_name
     */
    public String getRaport_name() {
        return raport_name;
    }
    /**
     * przypisywanie nazwy do konrketnego raportu
     * @param raport_name nazwa raportu
     */
    public void setRaport_name(String raport_name) {
        this.raport_name = raport_name;
    }

    /**
     * pobieranie identyfikatora glosowania
     * @return vote_id
     */
    public Integer getVote_id() {
        return vote_id;
    }
    /**
     * przypisywanie identyfikator glosowania
     * @param vote_id id glosowania
     */
    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }
    /**
     * ustawienie daty glosowania
     * @return datatime
     */
    public String getDatatime() {
        return datatime;
    }
    /**
     * przypisywanie daty glosowania
     * @param datatime data glosowania
     */
    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    /**
     * pobieranie o czym byl raport
     * @return raport_content
     */
    public String getRaport_content() {
        return raport_content;
    }
    /**
     * przypisywanie kontentu do raportu
     * @param raport_content kontent raportu
     */
    public void setRaport_content(String raport_content) {
        this.raport_content = raport_content;
    }
}
