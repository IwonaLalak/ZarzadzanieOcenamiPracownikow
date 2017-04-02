package sample.database.entity;

/*
@Entity
@Table( name = "Votes" )*/

public class Votes {
    private int id;
    private String vote_name;
    private String datatime;
    private int is_current;
    private String who;
    private int section_id;
    private int questionform_id;

    public Votes(int id, String vote_name, String datatime, int is_current, String who, int section_id, int questionform_id){
        this.id = id;
        this.vote_name = vote_name;
        this.datatime = datatime;
        this.is_current = is_current;
        this.who = who;
        this.section_id = section_id;
        this.questionform_id = questionform_id;

    }

    public Votes(){

    }

    public int getId() {
        return id;
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

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
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
}
