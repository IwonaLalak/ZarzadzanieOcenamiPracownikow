package sample.tests;

import org.junit.Test;
import sample.database.entity.Votes;

import static org.junit.Assert.*;


public class VotesTest {
    @Test
    public void getId() throws Exception {
        Votes obj = new Votes();
        int id = 232;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }


    @Test
    public void setId() throws Exception {
        Votes obj = new Votes();
        int id = 232;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void getVote_name() throws Exception {
        Votes obj = new Votes();
        String text = "test";
        obj.setVote_name(text);
        assertEquals(text, obj.getVote_name());
        obj.setVote_name(null);
        assertNull(obj.getVote_name());
    }

    @Test
    public void setVote_name() throws Exception {
        Votes obj = new Votes();
        String text = "test";
        obj.setVote_name(text);
        assertEquals(text, obj.getVote_name());
        obj.setVote_name(null);
        assertNull(obj.getVote_name());
    }

    @Test
    public void getWho() throws Exception {
        Votes obj = new Votes();
        String text = "test";
        obj.setWho(text);
        assertEquals(text, obj.getWho());
        obj.setWho(null);
        assertNull(obj.getWho());

    }

    @Test
    public void setWho() throws Exception {
        Votes obj = new Votes();
        String text = "test";
        obj.setWho(text);
        assertEquals(text, obj.getWho());
        obj.setWho(null);
        assertNull(obj.getWho());
    }

    @Test
    public void getSection_id() throws Exception {
        Votes obj = new Votes();
        int id = 2232;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void setSection_id() throws Exception {
        Votes obj = new Votes();
        int id = 2232;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void getQuestionform_id() throws Exception {
        Votes obj = new Votes();
        int id = 232;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void setQuestionform_id() throws Exception {
        Votes obj = new Votes();
        int id = 232;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

}