package org.example.java3_final_project.tables;

import org.example.java3_final_project.dao.CategoryDAO;
import org.example.java3_final_project.dao.ComplaintDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Complaint;

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
                        data.getString(COMPLAINT_COLUMN_FLAT_ID)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return complaints;
    }

    @Override
    public void openComplaints(String status) {
        //TODO need to create method body
    }

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
                    data.getString(COMPLAINT_COLUMN_FLAT_ID)));
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
                COMPLAINT_COLUMN_FLAT_ID + ") VALUES ('" +
                complaint.getDescription() + "','" +
                complaint.getStatus() + "','" + complaint.getUser_id() + "','" + complaint.getFlat_num() +
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
