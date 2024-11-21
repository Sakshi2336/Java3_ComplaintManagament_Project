package org.example.java3_final_project.tables;

import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;
import org.example.java3_final_project.dao.UserDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Category;
import org.example.java3_final_project.pojo.DisplayTenant;
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

    @Override
    public ArrayList<User> getAllManager() {
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + USER_COLUMN_USER_TYPE_ID + " = 1;";
        managers = new ArrayList<User>();
        try {
            Statement getManagers = db.getConnection().createStatement();
            ResultSet data = getManagers.executeQuery(query);

            while(data.next()) {
                managers.add(new User(
                        data.getInt(USER_COLUMN_ID),
                        data.getString(USER_COLUMN_FIRST_NAME),
                        data.getString(USER_COLUMN_LAST_NAME),
                        data.getInt(USER_COLUMN_USER_TYPE_ID)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }

    @Override
    public ArrayList<DisplayTenant> getPrettyTenants() {
        ArrayList<DisplayTenant> tenants = new ArrayList<DisplayTenant>();
        String query = " SELECT first_name,last_name,flat_num " +
                "FROM tenant_info " +
                "ORDER BY flat_num ASC";

        try {
            Statement getTenants = db.getConnection().createStatement();
            ResultSet data = getTenants.executeQuery(query);
            while (data.next()) {
                tenants.add(new DisplayTenant(data.getString("first_name"),
                        data.getString("last_name"),
                        data.getString("flat_num")
                ));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tenants;
    }
    }



