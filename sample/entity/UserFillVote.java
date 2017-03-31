package sample.entity;


public class UserFillVote {

    private int id;
    private int user_id;
    private int vote_id;
    private int filled;

    public UserFillVote(int id, int user_id, int vote_id, int filled){
        this.id = id;
        this.user_id = user_id;
        this.vote_id = vote_id;
        this.filled = filled;
    }

    public UserFillVote(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getVote_id() {
        return vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }
}
