package org.example.java3_final_project.pojo;

public class ComplaintCategory {

    private int complaint_id;
    private int category_id;

    public ComplaintCategory(int complaint_id, int category_id) {
        this.complaint_id = complaint_id;
        this.category_id = category_id;
    }


    public ComplaintCategory(){

    }

    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    //TODO need to add toString method
}
