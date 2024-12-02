package org.example.java3_final_project.database;

import java.sql.*;

/**
 * The Database class is for connecting to the database
 * This class has private constructor which is for singleton pattern
 * This class is creating tables if there are not already exist.
 */
public class Database {


    //Instance of the database class
    private static Database instance;

    //connection of the database
    private Connection connection = null;

    /**
     * Private constructor for singleton pattern.
     * It reads the database credentials from the file, establishes the database connection,
     * and make sure that necessary tables are created in the database.
     */
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
            createTable(DBConst.TABLE_CATEGORY, DBConst.CREATE_TABLE_CATEGORY, connection);
            createTable(DBConst.TABLE_FLAT, DBConst.CREATE_TABLE_FLAT, connection);
            createTable(DBConst.TABLE_USER_TYPE, DBConst.CREATE_TABLE_USER_TYPE, connection);
            createTable(DBConst.TABLE_USER, DBConst.CREATE_TABLE_USER, connection);
            createTable(DBConst.TABLE_FLAT_USER, DBConst.CREATE_TABLE_FLAT_USER, connection);
            createTable(DBConst.TABLE_COMPLAINT, DBConst.CREATE_TABLE_COMPLAINT, connection);
            createTable(DBConst.TABLE_COMPLAINT_CATEGORY, DBConst.CREATE_TABLE_COMPLAINT_CATEGORY, connection);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Get the instance of the Database class if it is already exists
     * and if it is null then create one
     * @return either existing Database instance or new created instance
     */
    public static Database getInstance(){
        if(instance == null){
            instance = new Database(); //here we can create bcz private has class access
        }
        return instance;
    }

    /**
     * Creates a table in the database if it doesn't already exist.
     * This method checks if a table with the specified name exists using the database metadata.
     * If the table does not exist, it executes the provided SQL query to create the table.
     * @param tableName the name of the table for create and check
     * @param tableQuery sql query to create table
     * @param connection connection to the database
     * @throws SQLException sql error when creating or checking for table
     */
    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTable;
        DatabaseMetaData md = connection.getMetaData();

        //Check if table exists or not
        ResultSet resultSet = md.getTables(CredentialReader.getDbName(), null, tableName, null);
        if(resultSet.next()){
            System.out.println(tableName + " table already exists");
        }
        else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }

    /**
     * get the connection to the database
     * @return connection to the database
     */
    public Connection getConnection(){
        return connection;
    }

}
