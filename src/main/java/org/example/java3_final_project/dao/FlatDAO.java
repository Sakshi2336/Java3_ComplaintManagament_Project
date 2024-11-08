package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.Flat;

import java.util.ArrayList;

public interface FlatDAO {

    public ArrayList<Flat> getAllFlat();
    public void deleteFlat(String flatID);
}
