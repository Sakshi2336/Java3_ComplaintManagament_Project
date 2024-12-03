package org.example.java3_final_project.tables;

import org.example.java3_final_project.dao.ComplaintCategoryDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.ComplaintCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.java3_final_project.database.DBConst.*;

/**
 * This class represents the table for interacting with the complaint_category table in the database.
 * It implements the ComplaintCategoryDAO interface to provide methods for managing complaint_category table's data.
 */
public class ComplaintCategoryTable implements ComplaintCategoryDAO {

    //Database class instance for executing queries
    Database db = Database.getInstance();

    /**
     * This method is counting any particular category from passed category id
     * @param category category id to fetch data from complaint_category tale
     * @return count of any particular category
     */
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


    /**
     * This method is for inserting record into compliant_category when user insert
     * any new complaint related category data will be inserted in complaint_category
     * table by this method
     * @param id passing complaint_id from complaint table
     */
    @Override
    public void insertQuery(int id) {
        String query = "INSERT INTO " + TABLE_COMPLAINT_CATEGORY +
                "(" + COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID + ", " +
                COMPLAINT_CATEGORY_COLUMN_CATEGORY_ID +  ") VALUES ( LAST_INSERT_ID(), " + id + ")";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record in complaint category table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will fetch category related to any complaint
     * @param complaint_id by passing complaint id
     * @return category id number
     */
    @Override
    public int getCategoryByComplaint(int complaint_id){
        String query = " SELECT " + COMPLAINT_CATEGORY_COLUMN_CATEGORY_ID + " FROM " +
                TABLE_COMPLAINT_CATEGORY + " WHERE " + COMPLAINT_CATEGORY_COLUMN_COMPLAINT_ID +
                " = " + complaint_id + ";";
        int category_id = 0;

        try{
            Statement getCategoryId = db.getConnection().createStatement();
            ResultSet data = getCategoryId.executeQuery(query);

            if(data.next()){
                category_id = data.getInt("category_id");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return category_id;
    }
}
