package org.example.java3_final_project;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.example.java3_final_project.CredentialReader.getDbUser;

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

}
