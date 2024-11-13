package org.example.java3_final_project.tables;

import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;
import org.example.java3_final_project.dao.UserDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Category;
import org.example.java3_final_project.pojo.User;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.java3_final_project.database.DBConst.*;

public class UserTable implements UserDAO {

    Database db = Database.getInstance();

    ArrayList<String> managers;

    ArrayList<String> tenants;
    @Override
    public ArrayList<User> getAllUser() {
        return null;
    }

    @Override
    public User getUserID(String first_name) {
        return null;
    }

    @Override
    public ArrayList<String> getManagerFullName() {
        String query = "SELECT CONCAT("+USER_COLUMN_FIRST_NAME+", ' ', "+USER_COLUMN_LAST_NAME+") AS full_name FROM "+TABLE_USER + " WHERE "+USER_COLUMN_USER_TYPE_ID+ " = 1;";
        // SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM `user` WHERE user_type_id = 1;
        managers = new ArrayList<>();
        try{
            Statement getCoins = db.getConnection().createStatement();
            ResultSet resultSet = getCoins.executeQuery(query);

            while (resultSet.next()) {
                // Here I want to fetch the 'full_name' instead of first and last names
                String fullName = resultSet.getString("full_name");

                // Add the User to the list
                managers.add(fullName);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return managers;
    }

    @Override
    public ArrayList<String> getTenantName() {
        String query = "SELECT CONCAT("+USER_COLUMN_FIRST_NAME+", ' ', "+USER_COLUMN_LAST_NAME+") AS full_name FROM "+TABLE_USER + " WHERE "+USER_COLUMN_USER_TYPE_ID+ " = 2;";
        // SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM `user` WHERE user_type_id = 2;
        tenants = new ArrayList<>();
        try{
            Statement getCoins = db.getConnection().createStatement();
            ResultSet resultSet = getCoins.executeQuery(query);

            while (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                tenants.add(fullName);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tenants;
    }
}
