package org.example.java3_final_project.tables;

import org.example.java3_final_project.dao.FlatUserDAO;
import org.example.java3_final_project.database.Database;

import java.sql.SQLException;

import static org.example.java3_final_project.database.DBConst.*;

public class FlatUserTable implements FlatUserDAO {

    Database db = Database.getInstance();
    @Override
    public void deleteFlatUserByUserId(int user_id, String flat_num) {
        String query = "DELETE FROM " + TABLE_FLAT_USER + " WHERE " +
                FLAT_USER_COLUMN_USER_ID + " = " + user_id + " AND " +
                FLAT_USER_COLUMN_FLAT_ID + " = " + flat_num + ";";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted record from flat_user table");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
