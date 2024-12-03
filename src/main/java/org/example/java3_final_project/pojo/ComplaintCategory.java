package org.example.java3_final_project.pojo;


/**
 * The ComplaintCategory class has 2 class members that is for columns into complaint_category table
 * This class has constructors,getters and setters for complaint_category table columns.
 */
public class ComplaintCategory {

    //class members
    private int complaint_id; //complaint id
    private int category_id; //category id with associated complaint


    /**
     * create object of complaintCategory class
     * @param complaint_id complaint id for any complaint
     * @param category_id category id with associated category for this complaint
     */
    public ComplaintCategory(int complaint_id, int category_id) {
        this.complaint_id = complaint_id;
        this.category_id = category_id;
    }


    /**
     * Default constructor for creating empty ComplaintCategory object
     */
    public ComplaintCategory(){

    }


    //getters and setters for class members
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

}
