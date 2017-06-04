package sample.tests;

import org.junit.Test;
import sample.database.entity.UserFillVote;

import static org.junit.Assert.*;


public class UserFillVoteTest {
    @Test
    public void getId() throws Exception {
        UserFillVote obj = new UserFillVote();
        int id = 23765652;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void setId() throws Exception {
        UserFillVote obj = new UserFillVote();
        int id = 75343;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void getUser_id() throws Exception {
        UserFillVote obj = new UserFillVote();
        int User_id = 22322;
        obj.setUser_id(User_id);
        assertEquals(User_id, obj.getUser_id());
    }

    @Test
    public void setUser_id() throws Exception {
        UserFillVote obj = new UserFillVote();
        int User_id = 22322;
        obj.setUser_id(User_id);
        assertEquals(User_id, obj.getUser_id());
    }

    @Test
    public void getVote_id() throws Exception {
        UserFillVote obj = new UserFillVote();
        int Vote_id = 34343;
        obj.setVote_id(Vote_id);
        assertEquals(Vote_id, obj.getVote_id());
    }

    @Test
    public void setVote_id() throws Exception {
            UserFillVote obj = new UserFillVote();
            int Vote_id = 34343;
            obj.setVote_id(Vote_id);
            assertEquals(Vote_id, obj.getVote_id());
    }


}