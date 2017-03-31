package sample.entity;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation_data() {
        return creation_data;
    }

    public void setCreation_data(String creation_data) {
        this.creation_data = creation_data;
    }

    public int getNumber_of_questions() {
        return number_of_questions;
    }

    public void setNumber_of_questions(int number_of_questions) {
        this.number_of_questions = number_of_questions;
    }
}
