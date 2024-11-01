package org.example.java3_final_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;


public class LoginForm extends Application {

    //adding another scene to navigate to when connection created
    Scene scene,scene1;
    @Override
    public void start(Stage stage) throws Exception {


        //Text node for showing message that input field is empty
        Text message_text = new Text();
        message_text.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,15));

        //scene 1 - welcome page
        Text welcome_text = new Text("Welcome to the Apartment Complaint Management System");
        Text description_text = new Text("Welcome to the Apartment Complaint Management System (ACMS), \n" +
                "\t your essential tool for efficiently handling tenant complaints.\n" +
                "Designed specifically for apartment managers, this application streamlines\n" +
                "the process of logging, tracking, and resolving complaints, ensuring that\n" +
                "\t  \t every issue is addressed in a timely manner.");
        Text end_text = new Text("Join us in transforming the way you manage apartment complaints. " +
                "Your first step towards streamlined operations begin here!");
        Button start_button = new Button("Let's Get Started!");

        //font styling
        Font font = Font.font("Arial",FontWeight.MEDIUM,FontPosture.REGULAR,15);
        welcome_text.setFont(font);
        description_text.setFont(font);
        end_text.setFont(font);

        //sub layout
        VBox title_vbox = new VBox(20,welcome_text,description_text,end_text);
        title_vbox.setAlignment(Pos.CENTER);
        HBox button_hbox = new HBox(start_button);
        button_hbox.setAlignment(Pos.CENTER);

        //root pane
        BorderPane root_scene1 = new BorderPane();
        root_scene1.setCenter(title_vbox);
        root_scene1.setBottom(button_hbox);
        scene1 = new Scene(root_scene1,700,600);

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

        //file
        File file = new File("credential.txt");

        //connection button
        Button save_button = new Button("Save");
        save_button.setOnAction(e->{

            //Checking that user fill every fields
            if(username_textfield.getText().isEmpty() || passwordField.getText().isEmpty() || server_textfield.getText().isEmpty() || database_textfield.getText().isEmpty()){
                message_text.setText("Please fill out necessary information");
            }else{
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    bufferedWriter.write(username_textfield.getText() + "\n");
                    bufferedWriter.write(passwordField.getText() + "\n");
                    bufferedWriter.write(server_textfield.getText() + "\n");
                    bufferedWriter.write(database_textfield.getText() + "\n");
                    bufferedWriter.close();
                    message_text.setText("Everything is Done!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });

        Button connection_button = new Button("Test Connection");
        connection_button.setOnAction(e->{
            if(username_textfield.getText().isEmpty() || passwordField.getText().isEmpty() || server_textfield.getText().isEmpty() || database_textfield.getText().isEmpty()) {
                message_text.setText("Please fill out necessary information");
            }else{
                Database db = Database.getInstance();
                if(Database.isConnection){
                    stage.setScene(scene1);
                }else{
                    message_text.setText("Failed to create the connection to the Database!");
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
        VBox vBox = new VBox(20,username_hBox,password_hBox,server_hbox,database_hbox,save_button,connection_button,message_text);
        vBox.setAlignment(Pos.CENTER);

        //root pane for main scene
        BorderPane root = new BorderPane();
        root.setCenter(vBox);

        scene = new Scene(root, 500, 500);
        stage.setTitle("Hello!");



        //check that file is already exists and then try to connect
        checkExistFile(stage,scene,scene1,message_text,file);

        //stage.setScene(scene1);
        stage.show();


    }


    private void checkExistFile(Stage stage, Scene LoginForm, Scene WelcomePage, Text message, File file) throws Exception {
        if(file.exists()){
            CredentialReader.readCredential();
            if((!CredentialReader.getDbUser().isEmpty())&&(!CredentialReader.getDbPass().isEmpty())&&(!CredentialReader.getDbName().isEmpty())&&(!CredentialReader.getSERVER().isEmpty())){
                Database db1 = Database.getInstance();
                System.out.println("Database class is working!");
                if(Database.isConnection){
                    System.out.println("Connection variable is also working!");
                    stage.setScene(WelcomePage);
                }else{
                    message.setText("Please fill correct information!");
                    stage.setScene(LoginForm);
                    System.out.println("Is this working?");
                }
            }else{
                System.out.println("Main else block working!");
                message.setText("Please fill out all necessary information to connect to the database!");
                stage.setScene(LoginForm);
            }
        }else{
            System.out.println("File does not exits!");
            if(file.createNewFile()){
                System.out.println("File is created " + file.getName());
            }
            stage.setScene(LoginForm);
        }

    }


    //there will be method that will try to connect and if it connects then we will close the connection and create file and write to it and connect it to the database

    public static void main(String[] args) {
        launch();
    }
}


