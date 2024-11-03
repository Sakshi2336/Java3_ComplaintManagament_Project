package org.example.java3_final_project;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;


public class LoginForm extends Application {

    //adding another scene to navigate to when connection created
    Scene scene,scene1;
    //file
    File file = new File("credential.txt");

    //Text node for showing message that input field is empty
    Text message_text = new Text();

    Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        //scene 1 - welcome page
        Text welcome_text = new Text("Welcome to the Apartment Complaint Management System");
        Text description_text = new Text("Welcome to the Apartment Complaint Management System (ACMS), \n" +
                "\tyour essential tool for efficiently handling tenant complaints.\n" +
                "Designed specifically for apartment managers, this application streamlines\n" +
                "the process of logging, tracking, and resolving complaints, ensuring that\n" +
                "\t  \t every issue is addressed in a timely manner.");
        Text end_text = new Text("Join us in transforming the way you manage apartment complaints.\n" +
                "\tYour first step towards streamlined operations begin here!");


        Button start_button = new Button("Let's Get Started!");
        start_button.setFont(Font.font("Arial", FontWeight.NORMAL, 30));

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(5), start_button);
        scaleTransition.setFromX(0.5);
        scaleTransition.setFromY(0.5);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setCycleCount(1);

        scaleTransition.play();

        //font styling
        // Font styling
        welcome_text.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        description_text.setFont(Font.font("Arial", FontWeight.NORMAL, 25));
        end_text.setFont(Font.font("Arial", FontWeight.NORMAL, 25));

        // Set text color using Color object
        welcome_text.setFill(Color.web("#2C3E50"));
        description_text.setFill(Color.web("#2C3E50"));
        end_text.setFill(Color.web("#2C3E50"));

        //sub layout
        VBox title_vbox = new VBox(40,welcome_text,description_text,end_text);
        title_vbox.setAlignment(Pos.CENTER);
        HBox button_hbox = new HBox(start_button);
        button_hbox.setAlignment(Pos.CENTER);
        button_hbox.setPadding(new Insets(50));

        //root pane
        BorderPane root_scene1 = new BorderPane();
        root_scene1.setCenter(title_vbox);
        root_scene1.setBottom(button_hbox);
        scene1 = new Scene(root_scene1,1100,600);


        /**
         * This is Login page
         * Here now I will change code like I will first create method that will
         * first try to connect to the database and if will be successful then only
         * I will write that information into credential file and make Database
         * object with correct credentials
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
                checkConnection(username_textfield.getText(),passwordField.getText(),database_textfield.getText(),server_textfield.getText());
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

        scene = new Scene(root, 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }




    /**
     * there will be method that will try to connect and if it connects then
     * I will close the connection and create file and write to it and
     * connect it to the database
     */

    public void checkConnection(String userName,String password,String dbName,String server){
        boolean isConnect = false;
        try{
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://"+server+"/" + dbName +
                                    "?serverTimezone=UTC", userName, password);
            isConnect = true;
            connection.close(); //closing this temporary connection
        }catch (Exception e){
            e.printStackTrace();
            message_text.setText("Failed to create connection!Try again.");
        }

        if(isConnect){//if connect is established then I will write into file
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(userName + "\n");
                bufferedWriter.write(password + "\n");
                bufferedWriter.write(server + "\n");
                bufferedWriter.write(dbName + "\n");
                bufferedWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //after writing to the file i will create Database class with
            //correct credentials only
            Database database = Database.getInstance();
            stage.setScene(scene1);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}


