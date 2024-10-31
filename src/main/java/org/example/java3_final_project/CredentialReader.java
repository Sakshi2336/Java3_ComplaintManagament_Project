package org.example.java3_final_project;

import java.io.File;
import java.util.Scanner;

public class CredentialReader{


    //Class properties
    private static String DB_NAME = null;
    private static String DB_PASS = null;
    private static String DB_USER = null;
    private static String SERVER = null;

    //getters and setters
    public static String getDbName() {
        return DB_NAME;
    }

    public static String getDbPass() {
        return DB_PASS;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getSERVER() {
        return SERVER;
    }

    public static void setDbName(String dbName) {
        DB_NAME = dbName;
    }

    public static void setDbPass(String dbPass) {
        DB_PASS = dbPass;
    }

    public static void setDbUser(String dbUser) {
        DB_USER = dbUser;
    }

    public static void setSERVER(String SERVER) {
        CredentialReader.SERVER = SERVER;
    }

    //Creating method that I can call from this class that will read from the file
    public static void readCredential() throws Exception{

        File file = new File("credential.txt");
        Scanner scanner = new Scanner(file);

        if(scanner.hasNextLine()){
            DB_USER = scanner.nextLine();
        }
        if(scanner.hasNextLine()){
            DB_PASS = scanner.nextLine();
        }
        if(scanner.hasNextLine()){
            SERVER = scanner.nextLine();
        }
        if(scanner.hasNextLine()){
            DB_NAME = scanner.nextLine();
        }
        scanner.close();

        System.out.println(getDbUser());
    }

    

    //method that will update the credentials in connection
    public static void updateCredentials(String userName,String password,String dbName,String server){
        CredentialReader.setDbUser(userName);
        CredentialReader.setDbPass(password);
        CredentialReader.setDbName(dbName);
        CredentialReader.setSERVER(server);
    }

}
