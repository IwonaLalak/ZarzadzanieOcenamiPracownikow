package sample.tests;

import org.junit.Assert;
import sample.ScreensController;
import sample.controllers.SeeVoteController;

public class SeeVoteTest {

    @org.junit.Test
    public void setScreenControllerTest() throws Exception {
        ScreensController screenParent = new ScreensController();
        SeeVoteController seeVoteController = new SeeVoteController();
        Assert.assertNull(seeVoteController.getScreenController());
        seeVoteController.setScreenParent(screenParent);
        Assert.assertNotNull(seeVoteController.getScreenController());
    }
}
