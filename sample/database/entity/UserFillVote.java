package sample.database.entity;

/**
 * klasa głosowania
 */
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
    /**
     * pobieranie identyfikatora
     * @return id
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
     * pobieranie id uzytkownika
     * @return user_id
     */

    public int getUser_id() {
        return user_id;
    }
    /**
     * przypisywanie identyfikatora uzytkownika by sprawdzic czy oddal glos czy nie
     * @param user_id identyfikator uzytkownika
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * pobieranie id glosowania
     * @return vote_id
     */
    public int getVote_id() {
        return vote_id;
    }
    /**
     * przypisywanie id glosowania
     * @param vote_id id glosowania
     */
    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    /**
     * pobieranie czy pracownik glosowal
     * @return filled
     */
    public int getFilled() {
        return filled;
    }
    /**
     * sprawdzanie czy pracownik glosowal
     * @param filled sprawdzenie glosowania
     */
    public void setFilled(int filled) {
        this.filled = filled;
    }
}
