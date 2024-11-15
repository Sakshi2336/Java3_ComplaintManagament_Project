package org.example.java3_final_project.tables;

import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;
import org.example.java3_final_project.dao.UserDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Category;
import org.example.java3_final_project.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.java3_final_project.database.DBConst.*;

public class UserTable implements UserDAO {

    Database db = Database.getInstance();

    ArrayList<User> managers;

    ArrayList<User> tenants;
    @Override
    public ArrayList<User> getAllUser() {
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + USER_COLUMN_USER_TYPE_ID + " = 2;";
        tenants = new ArrayList<User>();
        try {
            Statement getUsers = db.getConnection().createStatement();
            ResultSet data = getUsers.executeQuery(query);

            while(data.next()) {
                tenants.add(new User(
                        data.getInt(USER_COLUMN_ID),
                        data.getString(USER_COLUMN_FIRST_NAME),
                        data.getString(USER_COLUMN_LAST_NAME),
                        data.getInt(USER_COLUMN_USER_TYPE_ID)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenants;
    }



}
