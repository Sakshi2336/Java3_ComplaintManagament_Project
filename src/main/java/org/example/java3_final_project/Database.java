package org.example.java3_final_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Database instance;
    private Connection connection = null; //I have not created getters yet that is why it is showing that it is never used


    //as this constructor private i cannot create object in other class
    private Database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://"+CredentialReader.getSERVER()+"/" + CredentialReader.getDbName() +
                                    "?serverTimezone=UTC",
                            CredentialReader.getDbUser(),
                            CredentialReader.getDbPass());
            System.out.println("Created connection!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static Database getInstance(){
        if(instance == null){
            instance = new Database(); //here we can create bcz private has class access
        }
        return instance;
    }
}
