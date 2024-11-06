package org.example.java3_final_project.database;

import org.example.java3_final_project.CredentialReader;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Database instance;
    private Connection connection = null; //I have not created getters yet that is why it is showing that it is never used

    private Database(){
        try{
            CredentialReader.readCredential();
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

    public static Database getInstance(){
        if(instance == null){
            instance = new Database(); //here we can create bcz private has class access
        }
        return instance;
    }

    //getConnection method so that I can access connection in login form and update variables
    public Connection getConnection(){
        return connection;
    }

}
