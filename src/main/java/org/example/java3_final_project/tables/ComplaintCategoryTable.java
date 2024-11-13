package org.example.java3_final_project.tables;

import org.example.java3_final_project.dao.ComplaintCategoryDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.ComplaintCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.java3_final_project.database.DBConst.*;


public class ComplaintCategoryTable implements ComplaintCategoryDAO {

    Database db = Database.getInstance();
    @Override
    public int countComplaintByCategory(int category) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT * FROM " + TABLE_COMPLAINT_CATEGORY + " WHERE "
                                    + COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID + " = '" + category + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count = data.getRow();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
