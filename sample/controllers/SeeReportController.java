package sample.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Main;
import sample.ScreensController;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import sample.database.entity.Raports;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class SeeReportController implements Initializable, ControlledScreen {

    private ScreensController myController;
    public String finalContent;

    public SeeReportController(){
        this.reportTitle = new Label();
        this.reportContent = new Label();
    }

    @FXML
    public Label reportTitle;

    @FXML
    public Label reportContent;


    @FXML
    private void goBackToReports(ActionEvent event) throws IOException {
        this.reportContent.setText("");
        myController.setScreen(Main.main);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {

        this.myController = screenPage;
    }


    public String preLoad(Raports selectedRaport) {
        this.reportTitle.setText(selectedRaport.getRaport_name());

        try {
            String[] reportContent = selectedRaport.getRaport_content().split("<br/>");
            if (reportContent.length < 1) {
                this.reportContent.setText("Brak danych!");
                return null;
            }

            Map<String, Integer> map = new HashMap<String, Integer>();
            Map<String, Double> srednia = new HashMap<String, Double>();
            Map<String, Integer> kto = new HashMap<String, Integer>();

            for (String line : reportContent) {
                String actualKto = line.split(";")[0];
                String actualSrednia = line.split(";")[1];
                String question = line.split(";")[2];

                if (kto.containsKey(actualKto)) {
                    int count = kto.get(actualKto) + 1;
                    kto.put(actualKto, count);
                } else {
                    kto.put(actualKto, 1);
                }

                if (map.containsKey(question)) {
                    int count = map.get(question) + 1;
                    map.put(question, count);

                    Double wynik = srednia.get(question) + Double.parseDouble(actualSrednia);
                    srednia.put(question, wynik);
                } else {
                    map.put(question, 1);
                    srednia.put(question, Double.parseDouble(actualSrednia));
                }
            }

            StringBuilder content = new StringBuilder();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                DecimalFormat df = new DecimalFormat("#.##");
                content.append("Pytanie \"" + key + "\" oceniono " + value + " razy, ze średnią: " + df.format(srednia.get(key) / map.get(key)) + "\n");
            }

            String najczesciej = "";
            int value = 0;
            for (Map.Entry<String, Integer> entry : kto.entrySet()) {
                String key = entry.getKey();
                int ktoValue = entry.getValue();
                if (ktoValue > value) {
                    value = ktoValue;
                    najczesciej = key;
                }
            }

            content.append("\n\n\n Najczesciej ocenial: " + najczesciej);


            this.reportContent.setText(content.toString());
            this.finalContent = content.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.reportContent.setText("Dane niepoprawne lub ich brak!");
            return null;
        }
        return this.finalContent;
    }

    public Initializable getSeeReportController() {
        return this;
    }

    @FXML
    public Document generatePdf() {
        try {
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
            String dateString = dateFormat.format(currentDate);

            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream("report_" + dateString + ".pdf"));
            document.open();
            document.add(new Paragraph(this.reportTitle.getText() + " \n\n\n"));
            document.add(new Paragraph(this.finalContent));
            document.close();
            return document;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ScreensController getScreenController() {
        return this.myController;
    }
}
