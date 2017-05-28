package sample.tests;


import com.itextpdf.text.Document;
import javafx.application.Application;
import org.junit.*;

import sample.Main;
import sample.ScreensController;
import sample.controllers.SeeReportController;
import sample.database.entity.Raports;

public class SeeReportControllerTest {

    ScreensController screenParent;
    SeeReportController seeReportController;

    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        System.out.printf("About to launch FX App\n");
        Thread t = new Thread("JavaFX Init Thread") {
            public void run() {
                Application.launch(Main.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
        System.out.printf("FX App thread started\n");
        Thread.sleep(500);
    }

    @Before
    public void initialize() {
        this.screenParent = new ScreensController();
        this.seeReportController = new SeeReportController();
    }

    @org.junit.Test
    public void preLoadTest() {
        this.screenParent = new ScreensController();
        this.seeReportController = new SeeReportController();
        this.seeReportController.setScreenParent(screenParent);
        Raports raport = new Raports(1, "raport z glosowanietestowe5", 12, "2017-03-26 19:51:51.0", "adam nowak;3;Ocen zaangazowanie<br/>adam nowak;2;Ocen wiedze<br/>jan kowalski;3;Ocen zaangazowanie<br/>jan kowalski;4;Ocen wiedze<br/>michal adamczyk;3;Ocen zaangazowanie<br/>michal adamczyk;3;Ocen wiedze<br/>adam nowak;3;Ocen zaangazowanie<br/>adam nowak;2;Ocen wiedze<br/>jan kowalski;4;Ocen zaangazowanie<br/>jan kowalski;2;Ocen wiedze<br/>michal adamczyk;4;Ocen zaangazowanie<br/>michal adamczyk;3;Ocen wiedze<br/>");
        String finalContent = seeReportController.preLoad(raport);
        Assert.assertNotNull(finalContent);
        Assert.assertEquals(finalContent, "Pytanie \"Ocen wiedze\" oceniono 6 razy, ze średnią: 2.67\n" +
                "Pytanie \"Ocen zaangazowanie\" oceniono 6 razy, ze średnią: 3.33\n" +
                "\n" +
                "\n" +
                "\n" +
                " Najczesciej ocenial: jan kowalski");
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
    }

}

