package sample.database.entity;

/*
@Entity
@Table( name = "Logs" )*/

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_id() {
        return vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public String getLog_content() {
        return log_content;
    }

    public void setLog_content(String log_content) {
        this.log_content = log_content;
    }

    public String getLog_short() {
        return log_short;
    }

    public void setLog_short(String log_short) {
        this.log_short = log_short;
    }
}
