package dev.campbell.models;



public class Duelist {

    private int id;

    private String firstName;

    private String lastName;

    private String deckName;

    private String deckType;

    private String username;

    private String password;

    private boolean available = false;



    //Constructors
    public Duelist() {
    }

    public Duelist(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Duelist(String firstName, String lastName, String deckName, String deckType, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deckName = deckName;
        this.deckType = deckType;
        this.username = username;
        this.password = password;
    }

    public Duelist(int id, String firstName, String lastName, String deckName, String deckType, String username, String password, boolean available) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deckName = deckName;
        this.deckType = deckType;
        this.username = username;
        this.password = password;
        this.available = available;
    }



    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getDeckType() {
        return deckType;
    }

    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    @Override
    public String toString() {
        return "Duelist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deckName='" + deckName + '\'' +
                ", deckType='" + deckType + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", available=" + available +
                '}';
    }
}
