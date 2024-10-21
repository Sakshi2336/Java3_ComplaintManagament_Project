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
    @Override
    public void start(Stage stage) throws IOException {

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

        //Text node for showing message that input field is empty
        Text message_text = new Text();

        //connection button
        Button save_button = new Button("Save");
        save_button.setOnAction(e->{
            System.out.println("Button is working!");

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
            Database db = Database.getInstance();
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


        //root pane
        BorderPane root = new BorderPane();
        root.setCenter(vBox);

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
