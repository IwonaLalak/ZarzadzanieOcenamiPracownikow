package sample.tests;

import org.junit.Assert;
import sample.configuration.Logged;


public class LoggedTest {

    @org.junit.Test
    public void whoIsLoggedTest() throws Exception{
        Assert.assertNull(Logged.whoIsLogged());
    }
}
