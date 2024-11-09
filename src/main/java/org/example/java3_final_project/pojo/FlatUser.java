package org.example.java3_final_project.pojo;

public class FlatUser {

    private int flat_id;
    private int user_id;

    public FlatUser(int flat_id, int user_id) {
        this.flat_id = flat_id;
        this.user_id = user_id;
    }

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

    //TODO need to add toString method
}
