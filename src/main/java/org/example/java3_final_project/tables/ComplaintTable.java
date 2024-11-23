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

public class ComplaintTable implements ComplaintDAO {

    Database db = Database.getInstance();
    ArrayList<Complaint> complaints;
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
    public ArrayList<DisplayComplaint> getPrettyComplaints(){
        ArrayList<DisplayComplaint> complaints = new ArrayList<DisplayComplaint>();
        String query = " SELECT complaint.complaint_id, complaint.description," +
                "complaint.submit_time,complaint.status,user.first_name" +
                " AS tenant_name, flat.flat_num as flat_num,user.first_name " +
                "AS manager_name from complaint JOIN flat on complaint.flat_id = flat.flat_num " +
                "JOIN user on complaint.manager_id=user.user_id " +
        "ORDER BY complaint.complaint_id ASC";

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return complaints;
    }

//    public ArrayList<DisplayComplaint> openComplaints() {
//        ArrayList<DisplayComplaint> complaints = new ArrayList<DisplayComplaint>();
//        String query = " SELECT complaint.complaint_id, complaint.description," +
//                "complaint.submit_time,complaint.status,user.first_name" +
//                " AS tenant_name, flat.flat_num as flat_num,user.first_name " +
//                "AS manager_name from complaint JOIN flat on complaint.flat_id = flat.flat_num " +
//                "JOIN user on complaint.manager_id=user.user_id " +
//                "WHERE complaint.status = 'Open' OR complaint.status = 'open' " +
//                "ORDER BY complaint.complaint_id ASC";
//
//        try {
//            Statement getItems = db.getConnection().createStatement();
//            ResultSet data = getItems.executeQuery(query);
//            while(data.next()) {
//                complaints.add(new DisplayComplaint(data.getInt("complaint_id"),
//                        data.getString("description"),
//                        data.getString("submit_time"),
//                        data.getString("status"),
//                        data.getString("tenant_name"),
//                        data.getString("flat_num"),
//                        data.getString("manager_name")));
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return complaints;
//
//
//
//    }

    @Override
    public Complaint getComplaint(int complaintID) {
        String query = "SELECT * FROM " + TABLE_COMPLAINT + " WHERE " +
                COMPLAINT_COLUMN_ID + " = " + complaintID;
        Complaint complaint = new Complaint();
        try {
            Statement getItem = db.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            data.next();
            complaints.add(new Complaint(data.getInt(COMPLAINT_COLUMN_ID),
                    data.getString(COMPLAINT_COLUMN_DESCRIPTION),
                    data.getString(COMPLAINT_COLUMN_SUBMIT_TIME),
                    data.getString(COMPLAINT_COLUMN_STATUS),
                    data.getInt(COMPLAINT_COLUMN_USER_ID),
                    data.getInt(COMPLAINT_COLUMN_FLAT_ID),
                    data.getInt(COMPLAINT_COLUMN_MANAGER_ID)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaint;
    }

    @Override
    public void updateComplaint(Complaint complaint) {
        String query = "UPDATE " + TABLE_COMPLAINT + " SET " +
                COMPLAINT_COLUMN_ID + " " + complaint.getId() +  "," +
                COMPLAINT_COLUMN_DESCRIPTION + " " + complaint.getDescription() +  "," +
                COMPLAINT_COLUMN_SUBMIT_TIME + " " + complaint.getSubmit_time() + "," +
                COMPLAINT_COLUMN_STATUS + " " + complaint.getSubmit_time() +
                " WHERE " + COMPLAINT_COLUMN_ID + " = " + complaint.getId();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
