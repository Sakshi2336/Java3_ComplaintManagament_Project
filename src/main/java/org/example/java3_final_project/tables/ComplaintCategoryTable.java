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
                                    + COMPLAINT_CATEGORY_COLUMN_CATEGORY_ID + " = '" + category + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
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

    @Override
    public void insertQuery(int id) {
        String query = "INSERT INTO " + TABLE_COMPLAINT_CATEGORY +
                "(" + COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID + ", " +
                COMPLAINT_CATEGORY_COLUMN_CATEGORY_ID +  ") VALUES ( LAST_INSERT_ID(), " + id + ")";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record in complaint category table");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
