package org.example.java3_final_project.database;

import java.io.File;
import java.util.Scanner;

/**
 * The CredentialReader class is responsible for reading database credentials from a file
 * and providing static methods to access these credentials.
 * <p>
 * This class contains static properties for database name, username, password, and server,
 * and it provides getter and setter methods for each of these properties. It also includes
 * a method to read the credentials from a file called "credential.txt".
 * </p>
 *
 * @author Sakshi Patel
 */
public class CredentialReader{


    /**
     * Class properties
     * - Database name
     * - Database Password
     * - Database Username
     * - Server name
     */
    private static String DB_NAME = null;
    private static String DB_PASS = null;
    private static String DB_USER = null;
    private static String SERVER = null;

    //getters and setters

    /**
     * Get database name
     * @return database name
     */
    public static String getDbName() {
        return DB_NAME;
    }


    /**
     * Get database password
     * @return database password
     */
    public static String getDbPass() {
        return DB_PASS;
    }


    /**
     * Get Database username
     * @return Database username
     */
    public static String getDbUser() {
        return DB_USER;
    }

    /**
     * Get Server name
     * @return Server name
     */
    public static String getSERVER() {
        return SERVER;
    }


    /**
     * Read the credentials from file credential.txt
     * @throws Exception if an error i=occurs from reading the file
     */
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
    }



}
