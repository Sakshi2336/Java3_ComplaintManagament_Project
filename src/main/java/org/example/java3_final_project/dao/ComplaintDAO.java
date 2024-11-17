package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.Complaint;

import java.util.ArrayList;

public interface ComplaintDAO {

    public ArrayList<Complaint> getAllComplaint();

    //show open complaints only
    public void openComplaints();
    public Complaint getComplaint(int complaintID);
    public void updateComplaint(Complaint complaint);
    public void createComplaint(Complaint complaint);


}
