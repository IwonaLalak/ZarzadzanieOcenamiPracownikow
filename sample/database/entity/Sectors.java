package sample.database.entity;


/**
 * klasa dzialow
 */
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

    /**
     * pobierranie identyfikatora dzialu
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * przypisywanie identyfikatora do  dzialu
     * @param id identyfikator dzialu
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * pobieranie nazwy dzialu
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * przypisywanie nazwa dzialu
     * @param name nazwa dzialu
     */
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
