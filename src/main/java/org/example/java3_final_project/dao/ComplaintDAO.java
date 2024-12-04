package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.Complaint;
import org.example.java3_final_project.pojo.DisplayComplaint;

import java.util.ArrayList;

public interface ComplaintDAO {

    public ArrayList<Complaint> getAllComplaint();

    //show open complaints only
    public ArrayList<DisplayComplaint> openComplaints();
    public Complaint getComplaint(int complaintID);
    public void updateComplaint(Complaint complaint);
    public void createComplaint(Complaint complaint);

    public ArrayList<DisplayComplaint> getPrettyComplaints();


}
