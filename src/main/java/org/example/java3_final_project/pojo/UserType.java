package org.example.java3_final_project.pojo;


/**
 * This UserType class is for 2 different user like manager and tenant
 * This class has user id and user type class member which represent user_type table columns
 */
public class UserType {


    //class members
    private int id; //user id
    private String user_type;  // user type


    /**
     * Constructor of Usertype object which will require following properties
     * @param id user id
     * @param user_type user type manager or tenant
     */
    public UserType(int id, String user_type) {
        this.id = id;
        this.user_type = user_type;
    }


    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }


    /**
     * This will give string representation of UserType object
     * @return string representation of this class' object as user type either manager or tenant
     */
    public String toString(){
        return user_type;
    }
}
