package org.example.java3_final_project.pojo;

public class UserType {

    private int id;
    private String user_type;

    public UserType(int id, String user_type) {
        this.id = id;
        this.user_type = user_type;
    }

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

    public String toString(){
        return user_type;
    }
}
