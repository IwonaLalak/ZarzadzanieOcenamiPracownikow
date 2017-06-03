package sample.tests;

import org.junit.Assert;
import org.junit.Before;
import sample.ScreensController;
import sample.controllers.AddQuestionFormController;

public class AddQuestionFormControllerTest {

    ScreensController screenParent = new ScreensController();
    AddQuestionFormController addQuestionFormController = new AddQuestionFormController();


    @Before
    public void initialize() {
        this.screenParent = new ScreensController();
        this.addQuestionFormController = new AddQuestionFormController();
    }

    @org.junit.Test
    public void setScreenControllerTest() throws Exception {
        Assert.assertNull(addQuestionFormController.getScreenController());
        addQuestionFormController.setScreenParent(screenParent);
        Assert.assertNotNull(addQuestionFormController.getScreenController());
    }

}