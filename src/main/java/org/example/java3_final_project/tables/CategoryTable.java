package org.example.java3_final_project.tables;


import org.example.java3_final_project.dao.CategoryDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Category;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.java3_final_project.database.DBConst.*;

public class CategoryTable implements CategoryDAO {

    Database db = Database.getInstance();
    ArrayList<Category> categories;
    @Override
    public ArrayList<Category> getAllCategory() {
        String query = "SELECT * FROM " + TABLE_CATEGORY;
        // SELECT * FROM coin
        categories = new ArrayList<>();
        try{
            Statement getCoins = db.getConnection().createStatement();
            ResultSet resultSet = getCoins.executeQuery(query);
            /*
                id| name
                1 | Noise
                2 | Water
                3 | Heater
             */
            while(resultSet.next()){
                categories.add(new Category(
                        resultSet.getInt(CATEGORY_COLUMN_ID),     // ['id'] = 3
                        resultSet.getString(CATEGORY_COLUMN_NAME) // ['name'] = Water
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return categories;
    }
}
