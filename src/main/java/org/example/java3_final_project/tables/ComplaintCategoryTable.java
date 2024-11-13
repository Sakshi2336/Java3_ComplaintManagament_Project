package org.example.java3_final_project.tables;

import org.example.java3_final_project.dao.ComplaintCategoryDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.ComplaintCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.java3_final_project.database.DBConst.*;


public class ComplaintCategoryTable implements ComplaintCategoryDAO {

    Database db = Database.getInstance();
    @Override
    public void createComplaintCategory(ComplaintCategory complaintCategory) {

    }
}
