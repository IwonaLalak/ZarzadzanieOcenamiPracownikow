package sample.entity;

public class Raports {

    private int id;
    private String raport_name;
    private int vote_id;
    private String datatime;
    private String raport_content;

    public Raports(int id, String raport_name, int vote_id, String datatime, String raport_content){
        this.id = id;
        this.raport_name = raport_name;
        this.vote_id = vote_id;
        this.datatime = datatime;
        this.raport_content = raport_content;
    }

    public Raports(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaport_name() {
        return raport_name;
    }

    public void setRaport_name(String raport_name) {
        this.raport_name = raport_name;
    }

    public int getVote_id() {
        return vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public String getRaport_content() {
        return raport_content;
    }

    public void setRaport_content(String raport_content) {
        this.raport_content = raport_content;
    }
}
