package org.example.java3_final_project.pojo;


/**
 * This class is for showing complaint information to user in good way like
 * actually showing tenant name and manager name instead of
 * showing user_id or flat_id foreign keys in complaint table
 * The DisplayComplaint class has 7 class members that is for columns into pretty_complaint view
 * This class has constructors,getters for pretty_complaint view columns.
 */
public class DisplayComplaint {


    ///class members
    private int id; //id for complaint
    private String description; //complaint description
    private String submit_time; //complaint submit time
    private String status; //complaint status
    private String tenant_name; //tenant name who has this complaint
    private String flat_num; //flat number which has complaint
    private String manager_name; //Assigned manager


    /**
     * create object of this class with following details
     * @param id id for complaint
     * @param description complaint description
     * @param submit_time complaint submit time
     * @param status complaint status
     * @param tenant_name tenant name who has this complaint
     * @param flat_num flat number which has complaint
     * @param manager_name Assigned manager
     */
    public DisplayComplaint(int id, String description, String submit_time, String status, String tenant_name, String flat_num, String manager_name) {
        this.id = id;
        this.description = description;
        this.submit_time = submit_time;
        this.status = status;
        this.tenant_name = tenant_name;
        this.flat_num = flat_num;
        this.manager_name = manager_name;
    }


    //getters for class members
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getSubmit_time() {
        return submit_time;
    }

    public String getStatus() {
        return status;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public String getFlat_num() {
        return flat_num;
    }

    public String getManager_name() {
        return manager_name;
    }


}
