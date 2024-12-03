package org.example.java3_final_project.tables;

import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;
import org.example.java3_final_project.dao.UserDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Category;
import org.example.java3_final_project.pojo.DisplayComplaint;
import org.example.java3_final_project.pojo.DisplayTenant;
import org.example.java3_final_project.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.java3_final_project.database.DBConst.*;



/**
 * This class represents the table for managing user data in the database.
 * It implements the UserDAO interface to provide methods for retrieving user records,
 * as well as managing tenants and managers, and handling user deletions.
 */
public class UserTable implements UserDAO {


    //Database class instance for executing queries
    Database db = Database.getInstance();


    //ArrayList for managers from users table
    ArrayList<User> managers;


    //ArrayList for tenants from users table
    ArrayList<User> tenants;

    /**
     * This method will fetch data from users table
     * @return ArrayList of all users
     */
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


    /**
     * This method will fetch first name from users table
     * @param id user id
     * @return String first name
     */
    public String getUserFirstName(int id){
        String firstName = null;
        String query = " SELECT " + USER_COLUMN_FIRST_NAME + " FROM " + TABLE_USER +
                " WHERE " + USER_COLUMN_ID + " = " + id + ";";

        try{
            Statement getUser = db.getConnection().createStatement();
            ResultSet data = getUser.executeQuery(query);

            if(data.next()){
                firstName = data.getString("first_name");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return firstName;
    }


    /**
     * This method fetch managers from users table
     * @return ArrayList of managers
     */
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


    /**
     * This method will fetch data from tenant_info view which has information from users and flat table
     * @return tenant information with id,first-last name and flat number
     */
    @Override
    public ArrayList<DisplayTenant> getPrettyTenants() {
        ArrayList<DisplayTenant> tenants = new ArrayList<DisplayTenant>();
        String query = " SELECT * FROM " + VIEW_TENANT_INFO +
                " ORDER BY flat_num ASC ";

        try {
            Statement getTenants = db.getConnection().createStatement();
            ResultSet data = getTenants.executeQuery(query);
            while (data.next()) {
                tenants.add(new DisplayTenant(
                        data.getString("user_id"),
                        data.getString("first_name"),
                        data.getString("last_name"),
                        data.getString("flat_num")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenants;


    }


    /**
     * This method will delete tenant data from users table based on
     * @param id user_id
     */
    @Override
    public void deleteTenantFromUsers(String id) {
        String query  = "DELETE FROM " + TABLE_USER + " WHERE " +
                USER_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted record from users table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will delete associated data into flat_user table
     * @param id user_id
     */
    @Override
    public void deleteTenantFromFlatUser(String id) {
        String query  = "DELETE FROM " + TABLE_FLAT_USER + " WHERE " +
                FLAT_USER_COLUMN_USER_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted record from flat user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}











