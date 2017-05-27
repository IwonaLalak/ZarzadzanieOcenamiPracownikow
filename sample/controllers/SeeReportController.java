package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Main;
import sample.ScreensController;
import sample.interfaces.ControlledScreen;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import sample.database.entity.Raports;

public class SeeReportController implements Initializable, ControlledScreen {

    private ScreensController myController;

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
    public void initialize(URL location, ResourceBundle resources) {}

    @Override
    public void setScreenParent(ScreensController screenPage) {
        
        this.myController = screenPage;
    }
   
    public void preLoad(Raports selectedRaport )
    {
        
        this.reportTitle.setText(selectedRaport.getRaport_name());
        
        try{
            
            String[] reportContent = selectedRaport.getRaport_content().split("<br/>");
            if(reportContent.length < 1)
            {
                this.reportContent.setText("Brak danych!");
                return;
            }

            Map<String, Integer> map = new HashMap<String, Integer>();
            Map<String, Double> srednia = new HashMap<String, Double>();
            Map<String, Integer> kto = new HashMap<String, Integer>();
            
            for ( String line : reportContent) {
                String actualKto = line.split(";")[0];
                String actualSrednia = line.split(";")[1];
                String question = line.split(";")[2];
                
                if(kto.containsKey(actualKto)) {
                    int count = kto.get(actualKto) + 1;
                    kto.put(actualKto, count);
                }
                else
                {
                    kto.put(actualKto, 1);
                }
                
                if(map.containsKey(question) )
                {
                    int count = map.get(question) + 1;
                    map.put(question, count);
                    
                    Double wynik = srednia.get(question) + Double.parseDouble(actualSrednia); 
                    srednia.put(question, wynik);
                }
                else{
                    map.put(question, 1);
                    srednia.put(question, Double.parseDouble(actualSrednia));
                }
            }
            
            StringBuilder content = new StringBuilder();
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                
                content.append("Pytanie \"" + key + "\" oceniono " + value +" razy, ze średnią: " + srednia.get(key) + "\n");
            }
            
            String najczesciej = "";
            int value = 0;
            for (Map.Entry<String, Integer> entry : kto.entrySet()) {
                String key = entry.getKey();
                int ktoValue = entry.getValue();
                if(ktoValue > value ){
                    value = ktoValue;
                    najczesciej = key;
                }
            }
            
            content.append("\n\n\n Najczesciej ocenial: " + najczesciej);
           

           this.reportContent.setText(content.toString());
        }
        catch( Exception e)
        {
            System.out.println(e.getMessage());
            this.reportContent.setText("Dane niepoprawne lub ich brak!");
        }
    }
    
    public Initializable getSeeReportController()
    {
        return this;
    }
}
