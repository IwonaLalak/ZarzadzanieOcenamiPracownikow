package sample.entity;


public class Sectors {

    private int id;
    private String name;

    public Sectors(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Sectors(){
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
}
