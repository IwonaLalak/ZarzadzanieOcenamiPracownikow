package sample.tests;

import org.junit.Test;
import sample.database.entity.Sectors;

import static org.junit.Assert.*;

/**
 * Created by SzczureQ on 04.06.2017.
 */
public class SectorsTest {
    @Test
    public void getId() throws Exception {
        Sectors obj = new Sectors();
        int id = 23765652;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void setId() throws Exception {
        Sectors obj = new Sectors();
        int id = 23765652;
        obj.setId(id);
        assertEquals(id, obj.getId());
    }

    @Test
    public void getName() throws Exception {
        Sectors obj = new Sectors();
        String text = "test";
        obj.setName(text);
        assertEquals(text, obj.getName());
        obj.setName(null);
        assertNull(obj.getName());
    }

    @Test
    public void setName() throws Exception {
        Sectors obj = new Sectors();
        String text = "test";
        obj.setName(text);
        assertEquals(text, obj.getName());
        obj.setName(null);
        assertNull(obj.getName());
    }

}