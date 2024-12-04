package org.example.java3_final_project.tables;

import org.example.java3_final_project.dao.ComplaintDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Complaint;
import org.example.java3_final_project.pojo.DisplayComplaint;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static org.example.java3_final_project.database.DBConst.*;


/**
 * This class represents the table for managing complaint table in the database.
 * It implements the ComplaintDAO interface to provide methods for fetching, updating,
 * and inserting complaints.
 */
public class ComplaintTable implements ComplaintDAO {

    public ComplaintTable() {
        this.complaints = new ArrayList<>(); // Initialize the list

    };

    //Database class instance for executing queries
    Database db = Database.getInstance();

    //ArrayList for storing complaints
    ArrayList<Complaint> complaints;


    //Complaint table private instance
    private static ComplaintTable instance;

    /**
     * This method will check if complaint table instance is empty then create new one
     * and if it already exists then return that one
     * @return complaint table instance
     */
    public static ComplaintTable getInstance() {
        if (instance == null) {
            instance = new ComplaintTable();
        }
        return instance;
    }


    /**
     * This method will fetch every data from complaint table
     * @return ArrayList of complaint list
     */
    @Override
    public ArrayList<Complaint> getAllComplaint() {
        String query = "SELECT * FROM " + TABLE_COMPLAINT;
        complaints =new ArrayList<Complaint>();
        try{
            Statement getComplaints =db.getConnection().createStatement();
            ResultSet data =getComplaints.executeQuery(query);
            while(data.next()){
                complaints.add(new Complaint(data.getInt(COMPLAINT_COLUMN_ID),
                        data.getString(COMPLAINT_COLUMN_DESCRIPTION),
                        data.getString(COMPLAINT_COLUMN_SUBMIT_TIME),
                        data.getString(COMPLAINT_COLUMN_STATUS),
                        data.getInt(COMPLAINT_COLUMN_USER_ID),
                        data.getInt(COMPLAINT_COLUMN_FLAT_ID),
                        data.getInt(COMPLAINT_COLUMN_MANAGER_ID)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return complaints;
    }


    /**
     * This method will fetch data from pretty_complaint view for showing complaint information to the user
     * @return ArrayList of type DisplayComplaint , list of pretty complaint
     */
    @Override
    public ArrayList<DisplayComplaint> getPrettyComplaints(){
        ArrayList<DisplayComplaint> complaints = new ArrayList<DisplayComplaint>();
        String query = " SELECT * FROM " + VIEW_PRETTY_COMPLAINT + ";";

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                complaints.add(new DisplayComplaint(data.getInt("complaint_id"),
                        data.getString("description"),
                        data.getString("submit_time"),
                        data.getString("status"),
                        data.getString("tenant_name"),
                        data.getString("flat_num"),
                        data.getString("manager_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaints;
    }

    /**
     * This method will fetch every data from complaint table which has status to OPEN
     * @return ArrayList of pretty complaint type of DisplayComplaint
     */
    @Override
    public ArrayList<DisplayComplaint> openComplaints() {
        ArrayList<DisplayComplaint> complaints = new ArrayList<DisplayComplaint>();
        String query = " SELECT * FROM " + VIEW_PRETTY_COMPLAINT + " WHERE status = 'open'";

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                complaints.add(new DisplayComplaint(data.getInt("complaint_id"),
                        data.getString("description"),
                        data.getString("submit_time"),
                        data.getString("status"),
                        data.getString("tenant_name"),
                        data.getString("flat_num"),
                        data.getString("manager_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaints;



    }


    /**
     * This method will fetch every data of any complaint
     * @param complaintID by passed complaint id
     * @return complaint object
     */
    @Override
    public Complaint getComplaint(int complaintID) {
        String query = "SELECT * FROM " + TABLE_COMPLAINT + " WHERE " +
                COMPLAINT_COLUMN_ID + " = " + complaintID;
        Complaint complaint = new Complaint();
        try {
            Statement getItem = db.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            data.next();
            complaint = new Complaint(data.getInt(COMPLAINT_COLUMN_ID),
                    data.getString(COMPLAINT_COLUMN_DESCRIPTION),
                    data.getString(COMPLAINT_COLUMN_SUBMIT_TIME),
                    data.getString(COMPLAINT_COLUMN_STATUS),
                    data.getInt(COMPLAINT_COLUMN_USER_ID),
                    data.getInt(COMPLAINT_COLUMN_FLAT_ID),
                    data.getInt(COMPLAINT_COLUMN_MANAGER_ID));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaint;
    }


    /**
     * This method will update complaint object
     * @param complaint object to be updated
     */
    @Override
    public void updateComplaint(Complaint complaint) {
        String query = "UPDATE " + TABLE_COMPLAINT + " SET " +
                COMPLAINT_COLUMN_DESCRIPTION + "= '" + complaint.getDescription() +  "', " +
                COMPLAINT_COLUMN_STATUS + "= '" + complaint.getStatus() + "', " +
                COMPLAINT_COLUMN_MANAGER_ID + "= " + complaint.getManager_id() + " " +
                " WHERE " + COMPLAINT_COLUMN_ID + " = " + complaint.getId();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeUpdate(query);
            System.out.println("Record updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will insert new record into complaint table
     * @param complaint object to insert into table
     */
    @Override
    public void createComplaint(Complaint complaint) {
        String query = "INSERT INTO " + TABLE_COMPLAINT +
                "(" + COMPLAINT_COLUMN_DESCRIPTION + ", " +
                COMPLAINT_COLUMN_STATUS + "," +
                COMPLAINT_COLUMN_USER_ID + "," +
                COMPLAINT_COLUMN_FLAT_ID + "," +
                COMPLAINT_COLUMN_MANAGER_ID + ") VALUES ('" +
                complaint.getDescription() + "','" +
                complaint.getStatus() + "','" + complaint.getUser_id() + "','" + complaint.getFlat_num() + "','" + complaint.getManager_id() +
                "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
