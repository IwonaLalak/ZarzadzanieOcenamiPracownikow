package sample.database.entity;

/**
 * klasa pytan
 */
public class Questions {

    private int id;
    private String content;
    private int questionform_id;

    public Questions(int id, String content, int questionform_id){
        this.id = id;
        this.content = content;
        this.questionform_id = questionform_id;
    }

    public Questions(){
    }
    /**
     * pobieranie identyfikator pytania
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * przypisywanie identyfikatora pytania
     * @param id identyfikator pytania
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * pobieranie tresci pytania
     * @return concent
     */
    public String getContent() {
        return content;
    }
    /**
     * przypisywanie tresci pytania
     * @param content tresc pyttania
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * pobieranie pytan do konkretnego glosowania
     * @return questionform_id
     */
    public int getQuestionform_id() {
        return questionform_id;
    }
    /**
     * przypisanie pytan do konkretnego glosowania
     * @param questionform_id  pytanie
     */
    public void setQuestionform_id(int questionform_id) {
        this.questionform_id = questionform_id;
    }
}
