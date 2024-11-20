package org.example.java3_final_project;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.java3_final_project.MenuPage.MenuPage;
import org.example.java3_final_project.database.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The LoginForm class shows the main application for the
 * Apartment Complaint Management System.
 * It handles user input, database connection and welcome page
 */
public class LoginForm extends Application {

    /**
     * Class members-> There are 4 class members
     * Scene -> login_scene is for main scene and welcome_scene is for welcome page
     * file -> to hold file name
     * message_text -> to show message to user according to their actions
     * stage -> to hold current stage and to access stage in methods
     */
    Scene login_scene,welcome_scene;
    File file = new File("credential.txt");
    Text message_text = new Text();
    Stage stage;
    WelcomePage welcomePage = new WelcomePage();


    /**
     * main start method which will be executed when class run
     * @param stage -> primary stage for this application
     * @throws Exception -> if any error occurs during the initialization of application
     */
    @Override
    public void start(Stage stage) throws Exception {

        //setting primary stage to class member stage
        this.stage = stage;


        /**
         * login_scene -> Login form which will have
         * - labels and text fields for username,password,server name and database name
         * - text connection button to connect to database
         */
        //Labels for username,password,server location and database name
        Label username_label = new Label("Username:");
        Label password_label = new Label("Password:");
        Label server_label = new Label("Server Location:");
        Label database_label = new Label("Database Name:");

        //Text fields for inputs
        TextField username_textfield = new TextField();
        PasswordField passwordField = new PasswordField();
        TextField server_textfield = new TextField();
        TextField database_textfield = new TextField();

        Button connection_button = new Button("Test Connection");
        connection_button.setOnAction(e->{
            if(username_textfield.getText().isEmpty() || passwordField.getText().isEmpty() || server_textfield.getText().isEmpty() || database_textfield.getText().isEmpty()) {
                message_text.setText("Please fill out necessary information");
            }else{
                try {
                    checkConnection(username_textfield.getText(),passwordField.getText(),database_textfield.getText(),server_textfield.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

        });


        //HBox for putting labels and text field side by side
        HBox username_hBox = new HBox(42,username_label,username_textfield);
        HBox password_hBox = new HBox(43,password_label,passwordField);
        HBox server_hbox = new HBox(12,server_label,server_textfield);
        HBox database_hbox = new HBox(10,database_label,database_textfield);
        username_hBox.setAlignment(Pos.CENTER);
        password_hBox.setAlignment(Pos.CENTER);
        server_hbox.setAlignment(Pos.CENTER);
        database_hbox.setAlignment(Pos.CENTER);


        //sub layout vbox
        VBox vBox = new VBox(20,username_hBox,password_hBox,server_hbox,database_hbox,connection_button,message_text);
        vBox.setAlignment(Pos.CENTER);

        //root pane for main scene
        BorderPane root = new BorderPane();
        root.setCenter(vBox);

        login_scene = new Scene(root, 500, 500);
        stage.setTitle("Hello!");
        //stage.setScene(scene);
        checkForFile();
        stage.show();
    }


    /**
     * Attempts to connect to the database using provided credentials. If successful,
     * writes the credentials to a file and switches to the main scene.
     * @param user_name -> the username for the database connection
     * @param password -> the password for the database connection
     * @param dbName -> the name of the database
     * @param server -> the server location of the database
     */
    public void checkConnection(String user_name,String password,String dbName,String server) throws Exception {
        boolean isConnect = false; //boolean property to check if connection is failed or successful
        try{
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://"+server+"/" + dbName +
                                    "?serverTimezone=UTC", user_name, password);
            isConnect = true;
            connection.close(); //closing this temporary connection
        }catch (Exception e){
            e.printStackTrace();
            message_text.setText("Failed to create connection!Try again.");
        }

        if(isConnect){//if connect is established then write into file
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(user_name + "\n");
                bufferedWriter.write(password + "\n");
                bufferedWriter.write(server + "\n");
                bufferedWriter.write(dbName + "\n");
                bufferedWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //after writing to the file create Database class with correct credentials only
            Database database = Database.getInstance();
            welcomePage.start(stage);
            //stage.setScene(welcome_scene);
        }
    }

    /**
     * Checks for the existence of the credentials file. If it exists,
     * transitions to the main scene. If not, remains on the login scene.
     */
    public void checkForFile() throws Exception {
        if(file.exists()){
            Database database = Database.getInstance();
            welcomePage.start(stage);
            //stage.setScene(welcome_scene);
        }else{
            stage.setScene(login_scene);
        }
    }


    /**
     * The main method serves as the entry point for the JavaFX application.
     * @param args String type array
     */
    public static void main(String[] args) {
        launch();
    }
}


