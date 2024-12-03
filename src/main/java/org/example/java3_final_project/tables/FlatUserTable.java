package org.example.java3_final_project.tables;

import org.example.java3_final_project.dao.FlatUserDAO;
import org.example.java3_final_project.database.Database;

import java.sql.SQLException;

import static org.example.java3_final_project.database.DBConst.*;


/**
 * This class represents the table for managing the relationship between users and flat table in the database.
 * It implements the FlatUserDAO interface to provide methods for deleting user-flat associations.
 */
public class FlatUserTable implements FlatUserDAO {

    //Database class instance for executing queries
    Database db = Database.getInstance();


    /**
     * This method will delete record from FlatUser table based on user id and flat number
     * @param user_id user id from users table
     * @param flat_num flat id from flat table
     */
    @Override
    public void deleteFlatUserByUserId(int user_id, String flat_num) {
        String query = "DELETE FROM " + TABLE_FLAT_USER + " WHERE " +
                FLAT_USER_COLUMN_USER_ID + " = " + user_id + " AND " +
                FLAT_USER_COLUMN_FLAT_ID + " = " + flat_num + ";";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted record from flat_user table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
