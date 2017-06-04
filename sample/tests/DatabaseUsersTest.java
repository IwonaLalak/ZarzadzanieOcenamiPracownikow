package sample.tests;


        import org.junit.Assert;
        import org.junit.Test;
        import sample.database.Users;

/**
 * Created by SzczureQ on 04.06.17.
 */
public class DatabaseUsersTest {

    @Test
    public void getIdByUsernameTest() throws Exception{

        Users users = new Users();
        int id = users.getIdByUsername("ilalak");
        Assert.assertEquals(id, 1);
    }
}
