package org.example.java3_final_project.database;

public class DBConst {

    //Complaint Table
    public static final String TABLE_COMPLAINT = "complaint";
    public static final String COMPLAINT_COLUMN_ID = "complaint_id";
    public static final String COMPLAINT_COLUMN_DESCRIPTION = "description";
    public static final String COMPLAINT_COLUMN_SUBMIT_TIME = "submit_time";
    public static final String COMPLAINT_COLUMN_STATUS = "status";
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

    public static final String CREATE_TABLE_COMPLAINT =
            "CREATE TABLE " + TABLE_COMPLAINT + " (" +
                    COMPLAINT_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    COMPLAINT_COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                    COMPLAINT_COLUMN_SUBMIT_TIME + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                    COMPLAINT_COLUMN_STATUS + " VARCHAR(50) CHECK (" + COMPLAINT_COLUMN_STATUS + " IN ('open', 'in process', 'resolved')), " +
                    COMPLAINT_COLUMN_USER_ID + " INT, " +
                    COMPLAINT_COLUMN_FLAT_ID + " INT, " +
                    "FOREIGN KEY(" + COMPLAINT_COLUMN_USER_ID + ")" +
                    " REFERENCES " + TABLE_USER + "(" + USER_COLUMN_ID +")," +
                    "FOREIGN KEY(" + COMPLAINT_COLUMN_FLAT_ID + ")" +
                    " REFERENCES " + TABLE_FLAT + "(" + FLAT_COLUMN_NUM +"));";

    public static final String CREATE_TABLE_CATEGORY =
            "CREATE TABLE " + TABLE_CATEGORY + " (" +
                    CATEGORY_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    CATEGORY_COLUMN_NAME + " VARCHAR(50), " +
                    "PRIMARY KEY(" + CATEGORY_COLUMN_ID +"));";


    public static final String CREATE_TABLE_COMPLAINT_CATEGORY =
            "CREATE TABLE " + TABLE_COMPLAINT_CATEGORY + " (" +
                    COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID + " INT, " +
                    COMPLAINT_CATEGORY_COLUMN_CATEGORY_ID + " INT, " +
                    "FOREIGN KEY(" + COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID + ")" +
                    " REFERENCES " + TABLE_COMPLAINT + "(" + COMPLAINT_COLUMN_ID + ")" +
                    "FOREIGN KEY(" + COMPLAINT_CATEGORY_COLUMN_CATEGORY_ID + ")" +
                    " REFERENCES " + TABLE_CATEGORY + "(" + CATEGORY_COLUMN_ID +"));";


    public static final String CREATE_TABLE_USER =
            "CREATE TABLE " + TABLE_USER + " (" +
                    USER_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    USER_COLUMN_FIRST_NAME + " VARCHAR(50) NOT NULL, " +
                    USER_COLUMN_LAST_NAME + " VARCHAR(50) NOT NULL, " +
                    USER_COLUMN_USER_TYPE_ID + " INT, " +
                    "PRIMARY KEY(" + USER_COLUMN_ID + "), " +
                    "FOREIGN KEY (" + USER_COLUMN_USER_TYPE_ID + ")" +
                    " REFERENCES " + TABLE_USER_TYPE + "(" + USER_TYPE_COLUMN_ID +"));";


    public static final String CREATE_TABLE_USER_TYPE =
            "CREATE TABLE " + TABLE_USER_TYPE + " (" +
                    USER_TYPE_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    USER_TYPE_COLUMN_NAME + " VARCHAR(50) NOT NULL, " +
                    "PRIMARY KEY(" + USER_TYPE_COLUMN_ID +"));";


    public static final String CREATE_TABLE_FLAT =
            "CREATE TABLE " + TABLE_FLAT + " (" +
                    FLAT_COLUMN_NUM + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    FLAT_COLUMN_DESCRIPTION + " VARCHAR(255), " +
                    FLAT_COLUMN_HALL + " INT NOT NULL, " +
                    FLAT_COLUMN_BATH + " INT NOT NULL, " +
                    FLAT_COLUMN_KITCHEN + " INT NOT NULL" + ");";

    public static final String CREATE_TABLE_FLAT_USER =
            "CREATE TABLE " + TABLE_FLAT_USER + " (" +
                    FLAT_USER_COLUMN_USER_ID + " INT, " +
                    FLAT_USER_COLUMN_FLAT_ID + " INT, " +
                    "FOREIGN KEY(" + FLAT_USER_COLUMN_USER_ID + ")" +
                    " REFERENCES " + TABLE_USER + "(" + USER_COLUMN_ID + ")" +
                    "FOREIGN KEY(" + FLAT_USER_COLUMN_FLAT_ID + ")" +
                    " REFERENCES " + TABLE_FLAT + "(" + FLAT_COLUMN_NUM +"));";



}
