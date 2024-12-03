package org.example.java3_final_project.pojo;


/**
 * The DatabaseComplaint class has 1 class members that is for id of any table
 * This class has constructors,getters and setters for id of any table
 */
public class DatabaseComplaint {
    private int id;//id for any table

    /**
     * create object of this class
     * @param id id of any table from the database
     */
    public DatabaseComplaint(int id ){
        this.id = id;
    }


    //Getters and setters of class members
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
