package sample.entity;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuestionform_id() {
        return questionform_id;
    }

    public void setQuestionform_id(int questionform_id) {
        this.questionform_id = questionform_id;
    }
}
