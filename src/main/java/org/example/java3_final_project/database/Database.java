package org.example.java3_final_project.database;

import java.sql.*;

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

    public static Database getInstance(){
        if(instance == null){
            instance = new Database(); //here we can create bcz private has class access
        }
        return instance;
    }

    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTable;
        DatabaseMetaData md = connection.getMetaData();
        ResultSet resultSet = md.getTables("spateljava", null, tableName, null);
        if(resultSet.next()){
            System.out.println(tableName + " table already exists");
        }
        else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }

    //getConnection method so that I can access connection in login form and update variables
    public Connection getConnection(){
        return connection;
    }

}
