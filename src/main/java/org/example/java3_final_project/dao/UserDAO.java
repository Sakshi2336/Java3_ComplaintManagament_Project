package org.example.java3_final_project.dao;

import javafx.scene.text.Text;
import org.example.java3_final_project.pojo.DisplayTenant;
import org.example.java3_final_project.pojo.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface UserDAO {

    //Show all users
    public ArrayList<User> getAllUser();

    public ArrayList<User> getAllManager();

    public ArrayList<DisplayTenant> getPrettyTenants();



}
