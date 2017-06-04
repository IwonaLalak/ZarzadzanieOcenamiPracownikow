package sample.database.entity;
/**
 * klasa użytkowników
 */
public class Users {
    private int id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String type;
    private String sector_name;

    public Users(int id, String login, String password, String firstname, String lastname, String email, String type, String sector_name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.type = type;
        this.sector_name = sector_name;
    }

    public Users() {
    }
    /**
     * pobieranie id uzytkownika
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * przypisanie identyfiaktor uzytkownika
     * @param id identyfikator
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * pobieranie loginu
     * @return login
     */
    public String getLogin() {
        return login;
    }
    /**
     * przypisywanie login dla uzytkownika
     * @param login login uzytkownika
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * pobieranie hasla
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * przypisywanie hasla uzytkownika
     * @param password haslo
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * pobieranie imienia pracownika
     * @return firstname
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * przypisywanie imienia  pracownika
     * @param firstname imie pracownika
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * pobieranie nazwiska
     * @return lastname
     */
    public String getLastname() {
        return lastname;
    }
    /**
     * przypisanie nazwiska pracownika
     * @param lastname nazwisko pracownika
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * pobieranie stanowiska
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * przypisanie stanowiska
     * @param type stanowisko
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * pobieranie emaila pracownika
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * przypisanie emaila pracownika
     * @param email email pracownika
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * pobieranie nazwy dzialu
     * @return sector_name
     */
    public String getSector_name() {
        return sector_name;
    }
    /**
     * przypisanie nazwy dzialu
     * @param sector_name nazwa dzialu
     */
    public void setSector_name(String sector_name) {
        this.sector_name = sector_name;
    }
}
