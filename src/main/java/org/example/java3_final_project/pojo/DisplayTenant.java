package org.example.java3_final_project.pojo;


/**
 * This class is for showing tenant information to user with their relative flat number
 * in which they are living like instaed of running join query everytime create view
 * tenant_info so this class holds every data related to this view
 * The DisplayTenant class has 4 class members that is for columns into tenant_info view
 * This class has constructors,getters for tenant_info view columns.
 */
public class DisplayTenant {

    private String id; //user id from users class
    private String first_name; //tenant first name
    private String last_name; //tenant last name
    private String flat_num; //flat number for that particular tenant


    //Getters for class members
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFlat_num() {
        return flat_num;
    }
    /**
     * This will create object of this class for below details of tenants
     * @param id user_id from users table for which will uniquely identify that tenant
     * @param first_name first name of tenant
     * @param last_name last name of tenant
     * @param flat_num flat number
     */
    public DisplayTenant(String id, String first_name, String last_name, String flat_num) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.flat_num = flat_num;
    }

    /**
     * Default constructor for this class
     */
    public DisplayTenant(){

    }


}
