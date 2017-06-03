package sample.tests;

import org.junit.Assert;
import org.junit.Before;
import sample.ScreensController;
import sample.controllers.SeeQuestionFormController;

public class SeeQuestionFormControllerTest {

    ScreensController screenParent = new ScreensController();
    SeeQuestionFormController seeQuestionFormController = new SeeQuestionFormController();

    @Before
    public void initialize() {

    }


    @org.junit.Test
    public void setScreenControllerTest() throws Exception {
        Assert.assertNull(seeQuestionFormController.getScreenController());
        seeQuestionFormController.setScreenParent(screenParent);
        Assert.assertNotNull(seeQuestionFormController.getScreenController());
    }


}