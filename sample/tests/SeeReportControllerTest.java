package sample.tests;

import com.itextpdf.text.Document;
import org.junit.Assert;
import org.junit.Before;
import sample.ScreensController;
import sample.controllers.SeeReportController;
import sample.database.entity.Raports;

public class SeeReportControllerTest {

    ScreensController screenParent = new ScreensController();
    SeeReportController seeReportController = new SeeReportController();

    @Before
    public void initialize() {
        this.screenParent = new ScreensController();
        this.seeReportController = new SeeReportController();
    }

    @Before
    @org.junit.Test
    public void preLoadTest() {
//        Raports raport = new Raports();
//
//        this.seeReportController.
//
//        finalContent
        //int id, String raport_name, int vote_id, String datatime, String raport_content
    }

    @org.junit.Test
    public void setScreenControllerTest() throws Exception {
        Assert.assertNull(seeReportController.getScreenController());
        seeReportController.setScreenParent(screenParent);
        Assert.assertNotNull(seeReportController.getScreenController());
    }

    @org.junit.Test
    public void generatePdfTest() {
        Document document = this.seeReportController.generatePdf();
        Assert.assertNotNull(document);
        Assert.assertNotNull(this.seeReportController.reportTitle.getText());
        Assert.assertNotEquals(this.seeReportController.reportTitle.getText(), "");
        document.getJavaScript_onLoad().contains(this.seeReportController.reportTitle.getText());
    }


}
