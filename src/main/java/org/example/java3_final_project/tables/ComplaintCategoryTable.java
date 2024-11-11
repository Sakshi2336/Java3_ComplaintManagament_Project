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
    public ComplaintCategory getCategoriesByComplaint(int complaint_id) {
        String query = "SELECT * FROM " + TABLE_COMPLAINT_CATEGORY + " WHERE "
                + COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID + " = " + "'" + complaint_id + "'";
        ComplaintCategory complaintCategory = null;
        try {
            Statement getCategories = db.getConnection().createStatement();
            ResultSet data = getCategories.executeQuery(query);
            if(data.next()) {
                complaintCategory = new ComplaintCategory(
                        data.getInt(COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID),
                        data.getInt(COMPLAINT_CATEGORY_COLUMN_CATEGORY_ID));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return complaintCategory;
    }

    @Override
    public ComplaintCategory getComplaintsByCategory(int category_id) {
        return null;
    }

    @Override
    public void createComplaintCategory(ComplaintCategory complaintCategory) {

    }
}
