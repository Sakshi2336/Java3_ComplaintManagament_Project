package org.example.java3_final_project.pojo;

public class User extends DatabaseComplaint{
    private String first_name;
    private String last_name;
    private int type;

    public User(int id, String first_name, String last_name, int type) {
        super(id);
        this.first_name = first_name;
        this.last_name = last_name;
        this.type = type;
    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

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

    @Override
    public String toString() {
        return first_name + " " + last_name;
    }
}
