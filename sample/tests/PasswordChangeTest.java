package sample.tests;

import org.junit.Assert;
import org.junit.Before;
import sample.ScreensController;
import sample.controllers.PasswordChangeController;


public class PasswordChangeTest {

    ScreensController screenParent = new ScreensController();
    PasswordChangeController passwordChangeController = new PasswordChangeController();


    @Before
    public void initialize() {
        this.screenParent = new ScreensController();
        this.passwordChangeController = new PasswordChangeController();
    }

    @org.junit.Test
    public void setScreenControllerTest() throws Exception {
        Assert.assertNull(passwordChangeController.getScreenController());
        passwordChangeController.setScreenParent(screenParent);
        Assert.assertNotNull(passwordChangeController.getScreenController());
    }
}

