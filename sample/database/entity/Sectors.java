package sample.database.entity;


public class Sectors {

    private int id;
    private String name;
//  private String manager;

    public Sectors(int id, String name){
        this.id = id;
        this.name = name;
//      this.manager = manager;
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

 /*
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
 */
}
