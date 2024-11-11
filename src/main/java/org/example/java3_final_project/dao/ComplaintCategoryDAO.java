package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.ComplaintCategory;

import java.util.ArrayList;

public interface ComplaintCategoryDAO {

    //get all categories related to one complaint
    public ComplaintCategory getCategoriesByComplaint(int complaint_id);

    //get all complaints related to one category
    public ComplaintCategory getComplaintsByCategory(int category_id);

    //create new complaint-category link
    public void createComplaintCategory(ComplaintCategory complaintCategory);
}
