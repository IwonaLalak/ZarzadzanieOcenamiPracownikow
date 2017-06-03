package sample.database.entity;

/*
@Entity

@Table( name = "VotesFactory" )*/

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

    public int getId() {
        return id;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVote_name() {
        return vote_name;
    }

    public void setVote_name(String vote_name) {
        this.vote_name = vote_name;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public int getIs_current() {
        return is_current;
    }

    public void setIs_current(int is_current) {
        this.is_current = is_current;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public int getQuestionform_id() {
        return questionform_id;
    }

    public void setQuestionform_id(int questionform_id) {
        this.questionform_id = questionform_id;
    }

   /* public String getStatus() {
        return (this.filled == 1) ? "Wypełniona" : "Niewypełniona";
    }
*/
    public String isFilled() {
        return (this.filled == 0) ? "Niewypełniona" : "Wypełniona";
    }

    public String isEnded() {
        return (this.is_current == 1) ? "Nie" : "Tak";
    }
}

