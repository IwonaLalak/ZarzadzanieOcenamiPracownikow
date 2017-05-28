package sample.tests;

import org.junit.Assert;
import org.junit.Before;
import sample.ScreensController;
import sample.controllers.LoginController;
import sample.database.Model;

public class LoginControllerTest {

    ScreensController screenParent = new ScreensController();
    LoginController loginController = new LoginController();

    @Before
    public void initialize() {
        this.screenParent = new ScreensController();
        this.loginController = new LoginController();
    }

    @org.junit.Test
    public void setScreenControllerTest() throws Exception {
        Assert.assertNull(loginController.getScreenController());
        loginController.setScreenParent(screenParent);
        Assert.assertNotNull(loginController.getScreenController());
    }

    @org.junit.Test
    public void closeVoteFormIfExpiredTest() throws Exception {
        Model model = loginController.closeVoteFormIfExpired();
        Assert.assertEquals(model.get("is_current"), "0");
        Assert.assertNotNull(model.get("is_current"));
    }


}
