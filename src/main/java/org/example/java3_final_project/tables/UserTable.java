package org.example.java3_final_project.tables;

import javafx.scene.chart.PieChart;
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

    ArrayList<User> managers;
    @Override
    public ArrayList<User> getAllUser() {
        return null;
    }

    @Override
    public User getUserID(String first_name) {
        return null;
    }

    @Override
    public ArrayList<User> getManagerFullName() {
        String query = "SELECT CONCAT("+USER_COLUMN_FIRST_NAME+", ' ', "+USER_COLUMN_LAST_NAME+") AS full_name FROM "+TABLE_USER + "WHERE "+USER_COLUMN_USER_TYPE_ID + "= 1;";
        // SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM `user` WHERE user_type_id = 1;
        managers = new ArrayList<>();
        try{
            Statement getCoins = db.getConnection().createStatement();
            ResultSet resultSet = getCoins.executeQuery(query);

            while(resultSet.next()){
                managers.add(new User(
                        resultSet.getInt(USER_COLUMN_ID),
                        resultSet.getString(USER_COLUMN_FIRST_NAME),
                        resultSet.getString(USER_COLUMN_LAST_NAME),
                        resultSet.getInt(USER_COLUMN_USER_TYPE_ID)
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return managers;
    }
}
