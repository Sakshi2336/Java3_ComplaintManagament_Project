package org.example.java3_final_project.tables;

import org.example.java3_final_project.dao.FlatDAO;
import org.example.java3_final_project.database.Database;
import org.example.java3_final_project.pojo.Flat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.java3_final_project.database.DBConst.*;

public class FlatTable implements FlatDAO {
    Database db = Database.getInstance();
    ArrayList<Flat> flats;
        @Override
    public ArrayList<Flat> getAllFlat() {
        String query = "SELECT * FROM " + TABLE_FLAT;
        flats = new ArrayList<>();
        try{
            Statement getFlats = db.getConnection().createStatement();
            ResultSet resultSet =getFlats.executeQuery(query);

            while(resultSet.next()){
                flats.add(new Flat(resultSet.getString(FLAT_COLUMN_NUM),
                        resultSet.getString(FLAT_COLUMN_DESCRIPTION),
                        resultSet.getInt(FLAT_COLUMN_HALL),
                        resultSet.getInt(FLAT_COLUMN_BATH),
                        resultSet.getInt(FLAT_COLUMN_KITCHEN)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flats;
    }
}
