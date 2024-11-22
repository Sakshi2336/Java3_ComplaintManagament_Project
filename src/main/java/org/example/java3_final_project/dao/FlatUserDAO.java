package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.FlatUser;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface FlatUserDAO {

    public void deleteFlatUserByUserId(int user_id,String flat_num);
}
