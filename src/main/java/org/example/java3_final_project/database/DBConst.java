package org.example.java3_final_project.database;

public class DBConst {

    //Complaint Table
    public static final String TABLE_COMPLAINT = "complaint";
    public static final String COMPLAINT_COLUMN_ID = "complaint_id";
    public static final String COMPLAINT_COLUMN_DESCRIPTION = "description";
    public static final String COMPLAINT_COLUMN_SUBMIT_TIME = "submit_time";
    public static final String COMPLAINT_COLUMN_USER_ID = "user_id";
    public static final String COMPLAINT_COLUMN_FLAT_ID = "flat_id";

    //Category table
    public static final String TABLE_CATEGORY = "category";
    public static final String CATEGORY_COLUMN_ID = "category_id";
    public static final String CATEGORY_COLUMN_NAME = "category_name";



    // Complaint_Category Table
    public static final String TABLE_COMPLAINT_CATEGORY = "complaint_category";
    public static final String COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID = "complaint_id";
    public static final String COMPLAINT_CATEGORY_COLUMN_CATEGORY_ID = "category_id";


    // User Table
    public static final String TABLE_USER = "user";
    public static final String USER_COLUMN_ID = "user_id";
    public static final String USER_COLUMN_FIRST_NAME = "first_name";
    public static final String USER_COLUMN_LAST_NAME = "last_name";
    public static final String USER_COLUMN_USER_TYPE_ID = "user_type_id";


    // User_Type Table
    public static final String TABLE_USER_TYPE = "user_type";
    public static final String USER_TYPE_COLUMN_ID = "user_type_id";
    public static final String USER_TYPE_COLUMN_NAME = "user_type";


    // Flat Table
    public static final String TABLE_FLAT = "flat";
    public static final String FLAT_COLUMN_NUM = "flat_num";
    public static final String FLAT_COLUMN_DESCRIPTION = "description";
    public static final String FLAT_COLUMN_HALL = "hall";
    public static final String FLAT_COLUMN_BATH = "bath";
    public static final String FLAT_COLUMN_KITCHEN = "kitchen";


    // Flat_User Table
    public static final String TABLE_FLAT_USER = "flat_user";
    public static final String FLAT_USER_COLUMN_USER_ID = "user_id";
    public static final String FLAT_USER_COLUMN_FLAT_ID = "flat_id";


    //Table create statement


}
