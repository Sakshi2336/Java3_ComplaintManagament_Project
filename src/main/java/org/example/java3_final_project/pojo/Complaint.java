package org.example.java3_final_project.pojo;



/**
 * The Complaint class has 7 class members that is for columns into complaint table
 * This class has constructors,getters and setters for complaint table columns.
 */
public class Complaint {

    //class members
    private int id; //id for new complaint
    private String description; //description of complaint
    private String submit_time; //time when complaint submit
    private String status; //status for complaint open,close,resolved
    private int user_id; // tenant who has this complaint
    private int  flat_num; //flat number in which this complaint coming from
    private int manager_id; //manager whi will be handling at this complaint


    /**
     * create new complaint object with following details
     * @param id unique new complaint id
     * @param description the description of the complaint
     * @param submit_time the time when complaint was submitted
     * @param status Status of the complaint whether it is solved , open or in process
     * @param user_id tenant id who has this complaint
     * @param flat_num flat number for complaint
     * @param manager_id manager id who will look at this complaint
     */
    public Complaint(int id, String description, String submit_time, String status, int user_id, int flat_num,int manager_id) {
        this.id = id;
        this.description = description;
        this.submit_time = submit_time;
        this.status = status;
        this.user_id = user_id;
        this.flat_num = flat_num;
        this.manager_id = manager_id;
    }


    /**
     * create complaint object without complaint id needed
     * @param description the description of the complaint
     * @param status Status of the complaint whether it is solved , open or in process
     * @param user_id tenant id who has this complaint
     * @param flat_num flat number for complaint
     * @param manager_id manager id who will look at this complaint
     */
    public Complaint(String description, String status, int user_id, int flat_num, int manager_id) {
        this.description = description;
        this.status = status;
        this.user_id = user_id;
        this.flat_num = flat_num;
        this.manager_id = manager_id;
    }


    /**
     * Default constructor for empty complaint object
     */
    public Complaint(){

    }

    //Getters and setters for class members
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

    public int getFlat_num() {
        return flat_num;
    }

    public void setFlat_num(int flat_num) {
        this.flat_num = flat_num;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }


    /**
     * This method will give string representation of the complaint object
     * @return String representation of complaint object
     */
    public String toString(){
        return description;
    }
}
