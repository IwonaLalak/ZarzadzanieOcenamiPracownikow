package sample.tests;

import org.junit.Assert;
import org.junit.Test;
import sample.database.DbDetailsProvider;


public class DbDetailsProviderTest {

    @Test
    public void getUserTest() throws Exception {
        DbDetailsProvider dbDetails = new DbDetailsProvider();
        Assert.assertEquals(dbDetails.getUser(), "root");
    }

    @Test
    public void getPassTest() throws Exception {
        DbDetailsProvider dbDetails = new DbDetailsProvider();
        Assert.assertEquals(dbDetails.getPass(), "");
    }

    @org.junit.Test
    public void getHostTest() throws Exception {
        DbDetailsProvider dbDetails = new DbDetailsProvider();
        Assert.assertEquals(dbDetails.getHost(), "jdbc:mysql://localhost/zarzadzanie_pracownikami");
    }

    @org.junit.Test
    public void getDbNameTest() throws Exception {
        DbDetailsProvider dbDetails = new DbDetailsProvider();
        Assert.assertEquals(dbDetails.getDbName(), "zarzadzanie_pracownikami");
    }
}
