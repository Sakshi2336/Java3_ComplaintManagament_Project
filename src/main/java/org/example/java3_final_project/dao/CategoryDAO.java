package org.example.java3_final_project.dao;

import org.example.java3_final_project.pojo.Category;

import java.util.ArrayList;

public interface CategoryDAO {

    public ArrayList<Category> getAllCategory();
    public Category getCategory(int id);
}
