package org.example.java3_final_project.pojo;


/**
 * This FlatUser class is for connection flat and users table
 * This table has 2 class member flat_id and user_id as column from its respective tables.
 */
public class FlatUser {

    //class members
    private int flat_id; //flat number from flat table
    private int user_id; //user_id from users table


    /**
     * This will create object og this class with following properties
     * @param flat_id flat number from flat table
     * @param user_id user_id from users table
     */
    public FlatUser(int flat_id, int user_id) {
        this.flat_id = flat_id;
        this.user_id = user_id;
    }

    /**
     * Default constructor for this class' object
     */
    public FlatUser(){

    }

    //getters and setters
    public int getFlat_id() {
        return flat_id;
    }

    public void setFlat_id(int flat_id) {
        this.flat_id = flat_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
