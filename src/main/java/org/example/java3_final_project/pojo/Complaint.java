package org.example.java3_final_project.pojo;

public class Complaint {

    private int id;
    private String description;
    private String submit_time;
    private String status;
    private int user_id;
    private String  flat_num;

    public Complaint(int id, String description, String submit_time, String status, int user_id, String flat_num) {
        this.id = id;
        this.description = description;
        this.submit_time = submit_time;
        this.status = status;
        this.user_id = user_id;
        this.flat_num = flat_num;
    }

    public Complaint( String description,String status, int user_id, String flat_num) {
        this.description = description;
        this.status = status;
        this.user_id = user_id;
        this.flat_num = flat_num;
    }

    public Complaint(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(String submit_time) {
        this.submit_time = submit_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFlat_num() {
        return flat_num;
    }

    public void setFlat_num(String flat_num) {
        this.flat_num = flat_num;
    }

    public String toString(){
        return description;
    }
}
