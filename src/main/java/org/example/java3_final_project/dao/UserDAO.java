package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.User;

import java.util.ArrayList;

public interface UserDAO {

    //Show all users
    public ArrayList<User> getAllUser();

    /**
     * This method will get user id and I will store it into complaint table as user_id
     * when user enters name in add complaint form
     * @param first_name tenant input in add form
     * @return User with user_id which has that first name
     */
    public User getUserID(String first_name);

    //get manager(user_type) full name
    public ArrayList<String> getManagerFullName();
}
