package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.ComplaintCategory;

import java.util.ArrayList;

public interface ComplaintCategoryDAO {

    public int countComplaintByCategory(int category);

    public void insertQuery(int id);
    public int getCategoryByComplaint(int complaint_id);
}
