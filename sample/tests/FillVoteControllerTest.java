package sample.tests;

import org.junit.Assert;
import org.junit.Before;
import sample.ScreensController;
import sample.controllers.FillVoteController;

public class FillVoteControllerTest {

    ScreensController screenParent = new ScreensController();
    FillVoteController fillVoteController = new FillVoteController();


    @Before
    public void initialize() {
        this.screenParent = new ScreensController();
        this.fillVoteController = new FillVoteController();
    }

    @org.junit.Test
    public void setScreenControllerTest() throws Exception {
        Assert.assertNull(fillVoteController.getScreenController());
        fillVoteController.setScreenParent(screenParent);
        Assert.assertNotNull(fillVoteController.getScreenController());
    }
}