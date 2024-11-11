package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.User;

import java.util.ArrayList;

public interface UserDAO {

    //CRUD for any user
    public ArrayList<User> getAllUser();
    public User getUser(int userID);
    public void updateUser(User user);
    public void deleteUser(int userID);
    public void createUser(User user);
}
