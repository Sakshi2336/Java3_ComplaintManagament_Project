package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.FlatUser;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface FlatUserDAO {

    //get users living in one flat
    public ArrayList<FlatUser> getUsersByFlat(int flat_id);

    //get flats related to any user
    public ArrayList<FlatUser> getFlatsByUser(int user_id);

    //create new flat user
    public void createFlatUser(FlatUser flatUser);
}
