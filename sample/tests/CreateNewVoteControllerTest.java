package sample.tests;

import org.junit.Assert;
import org.junit.Test;
import sample.ScreensController;
import sample.controllers.CreateNewVoteController;

import static org.junit.Assert.*;


public class CreateNewVoteControllerTest {
    ScreensController screenParent = new ScreensController();
    CreateNewVoteController newVoteController = new CreateNewVoteController();

    @Test
    public void fill_comboboxes() throws Exception {

    }

    @Test
    public void initialize() throws Exception {
        this.screenParent = new ScreensController();
        this.newVoteController = new CreateNewVoteController();

    }

    @Test
    public void setScreenParent() throws Exception {
        ScreensController screenParent = new ScreensController();
        CreateNewVoteController CreateNewVoteController = new CreateNewVoteController();
        Assert.assertNull(CreateNewVoteController.getScreenController());
        CreateNewVoteController.setScreenParent(screenParent);
        Assert.assertNotNull(CreateNewVoteController.getScreenController());


    }

}