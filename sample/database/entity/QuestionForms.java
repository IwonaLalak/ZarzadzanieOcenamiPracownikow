package sample.database.entity;
/**
 * klasa ankiet
 */

public class QuestionForms {

    private int id;
    private String name;
    private String creation_data;
    private int number_of_questions;

    public QuestionForms(int id, String name, String creation_data, int number_of_questions){
        this.id = id;
        this.name = name;
        this.creation_data = creation_data;
        this.number_of_questions = number_of_questions;
    }

    public QuestionForms(){
    }
    /**
     * pobieranie id ankiety
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * przypisywanie identyfikatora ankiety
     * @param id id ankiety
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * pobieranie nazwy ankiety
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * przypisywanie nazwy ankiety
     * @param name nazwa ankiety
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * pobieranie daty utworzenia ankiety
     * @return creation_data
     */
    public String getCreation_data() {
        return creation_data;
    }
    /**
     * przypisywanie daty utworzenia ankiety
     * @param creation_data data utworzenia
     */
    public void setCreation_data(String creation_data) {
        this.creation_data = creation_data;
    }
    /**
     * pobieranie liczby pytan
     * @return  number_of_questions
     */
    public int getNumber_of_questions() {
        return number_of_questions;
    }
    /**
     * przypisywanie liczby pytan do ankiety
     * @param number_of_questions ilosc pytan
     */
    public void setNumber_of_questions(int number_of_questions) {
        this.number_of_questions = number_of_questions;
    }
}
