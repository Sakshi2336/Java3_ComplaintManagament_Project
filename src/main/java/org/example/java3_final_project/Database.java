package org.example.java3_final_project;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.example.java3_final_project.CredentialReader.getDbUser;

public class Database {

    private static Database instance;
    private Connection connection = null; //I have not created getters yet that is why it is showing that it is never used


    //as this constructor private I cannot create object in other class
    private Database(){
        try{
            //calling method from Credential reader class that will read from file and
            //set the variables value
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

    public static void main(String[] args) throws Exception {

        //CredentialReader.readCredential();
        //problem it is still being null without method call
        //System.out.println(CredentialReader.getSERVER());
        //after calling method now this is showing values
    }
}
