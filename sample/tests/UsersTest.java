package sample.tests;

import org.junit.Test;
import sample.database.entity.Users;

import static org.junit.Assert.*;

public class UsersTest {
    @Test
    public void getId() throws Exception {
        Users obj = new Users();
        int id = 123;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void setId() throws Exception {
        Users obj = new Users();
        int id = 123;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void getLogin() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setLogin(text);
        assertEquals(text, obj.getLogin());
        obj.setLogin(null);
        assertNull(obj.getLogin());
    }

    @Test
    public void setLogin() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setLogin(text);
        assertEquals(text, obj.getLogin());
        obj.setLogin(null);
        assertNull(obj.getLogin());
    }

    @Test
    public void getPassword() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setPassword(text);
        assertEquals(text, obj.getPassword());
        obj.setPassword(null);
        assertNull(obj.getPassword());
    }

    @Test
    public void setPassword() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setPassword(text);
        assertEquals(text, obj.getPassword());
        obj.setPassword(null);
        assertNull(obj.getPassword());
    }

    @Test
    public void getFirstname() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setFirstname(text);
        assertEquals(text, obj.getFirstname());
        obj.setFirstname(null);
        assertNull(obj.getFirstname());
    }

    @Test
    public void setFirstname() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setFirstname(text);
        assertEquals(text, obj.getFirstname());
        obj.setFirstname(null);
        assertNull(obj.getFirstname());
    }

    @Test
    public void getLastname() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setLastname(text);
        assertEquals(text, obj.getLastname());
        obj.setLastname(null);
        assertNull(obj.getLastname());
    }

    @Test
    public void setLastname() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setLastname(text);
        assertEquals(text, obj.getLastname());
        obj.setLastname(null);
        assertNull(obj.getLastname());
    }

    @Test
    public void getType() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setType(text);
        assertEquals(text, obj.getType());
        obj.setType(null);
        assertNull(obj.getType());
    }

    @Test
    public void setType() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setType(text);
        assertEquals(text, obj.getType());
        obj.setType(null);
        assertNull(obj.getType());
    }

    @Test
    public void getEmail() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setEmail(text);
        assertEquals(text, obj.getEmail());
        obj.setEmail(null);
        assertNull(obj.getEmail());
    }

    @Test
    public void setEmail() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setEmail(text);
        assertEquals(text, obj.getEmail());
        obj.setEmail(null);
        assertNull(obj.getEmail());
    }

    @Test
    public void getSector_name() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setSector_name(text);
        assertEquals(text, obj.getSector_name());
        obj.setSector_name(null);
        assertNull(obj.getSector_name());
    }

    @Test
    public void setSector_name() throws Exception {
        Users obj = new Users();
        String text = "test";
        obj.setSector_name(text);
        assertEquals(text, obj.getSector_name());
        obj.setSector_name(null);
        assertNull(obj.getSector_name());
    }


}