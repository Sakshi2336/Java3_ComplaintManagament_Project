package org.example.java3_final_project.pojo;


/**
 * This User class is representing users table from the database
 * This class has 3  class members which represent columns from the users table
 */
public class User extends DatabaseComplaint{

    //class members
    private String first_name; //user first name
    private String last_name; //user last name
    private int type; //user type like manager or tenant


    /**
     * Constructor for creating this class' object with following properties
     * @param id user id
     * @param first_name user first name
     * @param last_name user last name
     * @param type user type either manager or tenant
     */
    public User(int id, String first_name, String last_name, int type) {
        super(id);
        this.first_name = first_name;
        this.last_name = last_name;
        this.type = type;
    }

    //getters and setters
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * This will give string representation of User object
     * @return string representation of this class' object as full user name
     */
    @Override
    public String toString() {
        return first_name + " " + last_name;
    }
}
