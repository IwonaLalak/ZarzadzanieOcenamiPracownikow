package sample.database.entity;

/*
@Entity

@Table( name = "VotesFactory" )*/
/**
 * klasa głosowań
 */
public class Votes {
    private int id;
    private String vote_name;
    private String dateFrom;
    private String dateTo;
    private int is_current;
    private String who;
    private int section_id;
    private int questionform_id;
    private int filled;
    private String isEnded;
    private String isFilled;

    public Votes(int id, String vote_name, String dateFrom, String dateTo, int is_current, String who, int section_id, int questionform_id, String isFilled, String isEnded) {
        this.id = id;
        this.vote_name = vote_name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.is_current = is_current;
        this.who = who;
        this.section_id = section_id;
        this.questionform_id = questionform_id;
        this.isFilled=isFilled;
        this.isEnded = isEnded;
    }

    public Votes() {

    }
    /**
     * pobieranie id glosowania
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * ustawienie końca głosowania
     * @return dateto
     */
    public String getDateTo() {return dateTo;}
    /**
     * identyfikator glosowania
     * @param id identyfikator glosowania
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * pobieranie nazwy glosowania
     * @return vote_name
     */
    public String getVote_name() {
        return vote_name;
    }
    /**
     * nazwa glosowania
     * @param vote_name nazwa glosowania
     */
    public void setVote_name(String vote_name) {
        this.vote_name = vote_name;
    }
    /**
     * ustawienie poczatku glosowania
     * @return dateFrom
     */
    public String getDateFrom() {
        return dateFrom;
    }
    /**
     * ustawienie startu głosowania
     * @param dateFrom start glosowania
     */
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }
    /**
     * pobieranie czy glosowanie jest wlaczone czy wylaczone
     * @return is_current
     */
    public int getIs_current() {
        return is_current;
    }
    /**
     * przypisywanie czy glosowanie jest wlaczone czy wylaczone
     * @param is_current sprawdza czy glosowanie jest wlaczone
     */
    public void setIs_current(int is_current) {
        this.is_current = is_current;
    }
    /**
     * pobieranie kto ma glosowac
     * @return who
     */
    public String getWho() {
        return who;
    }
    /**
     * ustawienie kto ma glosowac
     * @param who kto glosuje
     */
    public void setWho(String who) {
        this.who = who;
    }
    /**
     * pobieranie w jakim dziale ma odbyc sie glosowanie
     * @return section_id
     */
    public int getSection_id() {
        return section_id;
    }
    /**
     * przypisywanie w jakim dziale odbedzie sie glosowanie
     * @param section_id sekcja ktora glosuje
     */
    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }
    /**
     * pobieranie identyfikatora glosowania
     * @return questionform_id
     */
    public int getQuestionform_id() {
        return questionform_id;
    }
    /**
     * przypisywanie ktore glosowanie sie odbedzie
     * @param questionform_id id glosowania
     */
    public void setQuestionform_id(int questionform_id) {
        this.questionform_id = questionform_id;
    }
    /**
     * czy glosowanie zostalo wypelnione
     * @return filled
     */


   /* public String getStatus() {
        return (this.filled == 1) ? "Wypełniona" : "Niewypełniona";
    }
*/

    /**
     * sprawdzenie czy glosowanie zostalo wypelnione
     * @return filled
     */
    public String isFilled() {
        return (this.filled == 0) ? "Niewypełniona" : "Wypełniona";
    }
    /**
     * czy glosowanie zostalo zakonczone
     * @return is_current
     */
    public String isEnded() {
        return (this.is_current == 1) ? "Nie" : "Tak";
    }
}

