package org.example.java3_final_project.tables;
import org.example.java3_final_project.dao.CategoryDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Category;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static org.example.java3_final_project.database.DBConst.*;


/**
 * This class represents the table for interacting with the category table in the database.
 * It implements the CategoryDAO interface to provide methods for fetching categories from category table.
 */
public class CategoryTable implements CategoryDAO {


    //Database class instance for executing queries
    Database db = Database.getInstance();

    //ArrayList to store categories
    ArrayList<Category> categories;


    /**
     * This method will fetch all categories from category table and
     * @return ArrayList of fetched categories from category table
     */
    @Override
    public ArrayList<Category> getAllCategory() {
        String query = "SELECT * FROM " + TABLE_CATEGORY;
        categories = new ArrayList<>();
        try{
            Statement getCoins = db.getConnection().createStatement();
            ResultSet resultSet = getCoins.executeQuery(query);
            while(resultSet.next()){
                categories.add(new Category(
                        resultSet.getInt(CATEGORY_COLUMN_ID),
                        resultSet.getString(CATEGORY_COLUMN_NAME)
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return categories;
    }


    /**
     * This method will get every data from category table based on any given category id
     * @param id category id that need to pass to fetch data
     * @return category name as String
     */
    @Override
    public String getCategory(int id){
        String query = "SELECT * FROM " + TABLE_CATEGORY +
                " WHERE " + CATEGORY_COLUMN_ID + " = " + id;
        String categoryName = null;
        try{
            Statement getCategory = db.getConnection().createStatement();
            ResultSet data = getCategory.executeQuery(query);
            if(data.next()){
                categoryName = data.getString("category_name");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return categoryName;
    }

}
