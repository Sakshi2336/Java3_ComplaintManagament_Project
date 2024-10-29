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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoginForm extends Application {

    //adding another scene to navigate to when connection created
    Scene scene,scene1;
    @Override
    public void start(Stage stage) throws Exception {


        //Text node for showing message that input field is empty
        Text message_text = new Text();

        //text for scene 1
        //root pane for scene 1
        Text text = new Text("Welcome Screen\nScene 1 is working!");
        BorderPane root_scene1 = new BorderPane();
        root_scene1.setCenter(text);
        scene1 = new Scene(root_scene1,600,600);

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


        //connection button
        Button save_button = new Button("Save");
        save_button.setOnAction(e->{

            //Checking that user fill every fields
            if(username_textfield.getText().isEmpty() || passwordField.getText().isEmpty() || server_textfield.getText().isEmpty() || database_textfield.getText().isEmpty()){
                message_text.setText("Please fill out necessary information");
            }else{
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("credential.txt"));
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

        //here i will call read method from CredentialReader class and then check
        //if DbUser name is not null then try to connect to the Database
        CredentialReader.readCredential();
        if((!CredentialReader.getDbUser().isEmpty())&&(!CredentialReader.getDbPass().isEmpty())&&(!CredentialReader.getDbName().isEmpty())&&(!CredentialReader.getSERVER().isEmpty())){
            Database db1 = Database.getInstance();
            System.out.println("Database class is working!");
            if(Database.isConnection){
                System.out.println("Connection variable is also working!");
                stage.setScene(scene1);
            }else{
                message_text.setText("Please fill correct information!");
                stage.setScene(scene);
                System.out.println("Is this working?");
            }
        }else{
            System.out.println("Main else block working!");
            message_text.setText("Please fill out all necessary information to connect to the database!");
            stage.setScene(scene);
        }

        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
