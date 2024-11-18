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
         *  welcome_scene -> welcome page which will show basic information for
         *  our application and have button that will navigate to the main menu page.
         *  This welcome page has:
         *  - text objects -> for welcome , description and end text
         *  - start button -> to navigate to the main menu page
         *  - scale transition for start button
         *  - TODO need to change animation on start button
         *  - title_vBox -> to pull all 3 text objects
         *  - button_hBox -> to put start button
         *  - welcome_scene_rootPane -> Borderpane as main root pane
         */

        Text welcome_text = new Text("Welcome to the Apartment Complaint Management System");
        Text description_text = new Text("Welcome to the Apartment Complaint Management System (ACMS), \n" +
                "\tyour essential tool for efficiently handling tenant complaints.\n" +
                "Designed specifically for apartment managers, this application streamlines\n" +
                "the process of logging, tracking, and resolving complaints, ensuring that\n" +
                "\t  \t every issue is addressed in a timely manner.");
        Text end_text = new Text("Join us in transforming the way you manage apartment complaints.\n" +
                "\tYour first step towards streamlined operations begin here!");

        // Font styling
        welcome_text.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        description_text.setFont(Font.font("Arial", FontWeight.NORMAL, 25));
        end_text.setFont(Font.font("Arial", FontWeight.NORMAL, 25));

        // Set text color using Color object
        welcome_text.setFill(Color.web("#2C3E50"));
        description_text.setFill(Color.web("#2C3E50"));
        end_text.setFill(Color.web("#2C3E50"));

        Button start_button = new Button("Let's Get Started!");
        start_button.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
        start_button.setOnAction(e->{
            MenuPage menuPage = new MenuPage();
            try {
                menuPage.start(stage);
            } catch (IOException ex) {
                System.out.println("Start button is not working!");
                throw new RuntimeException(ex);
            }
        });

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(5), start_button);
        scaleTransition.setFromX(0.5);
        scaleTransition.setFromY(0.5);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setCycleCount(1);
        scaleTransition.play();

        //sub layout
        VBox title_vbox = new VBox(40,welcome_text,description_text,end_text);
        title_vbox.setAlignment(Pos.CENTER);
        HBox button_hbox = new HBox(start_button);
        button_hbox.setAlignment(Pos.CENTER);
        button_hbox.setPadding(new Insets(50));

        //root pane
        BorderPane welcome_scene_rootPane = new BorderPane();
        welcome_scene_rootPane.setCenter(title_vbox);
        welcome_scene_rootPane.setBottom(button_hbox);
        welcome_scene = new Scene(welcome_scene_rootPane,1100,600);


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
    public void checkConnection(String user_name,String password,String dbName,String server){
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
            stage.setScene(welcome_scene);
        }
    }

    /**
     * Checks for the existence of the credentials file. If it exists,
     * transitions to the main scene. If not, remains on the login scene.
     */
    public void checkForFile(){
        if(file.exists()){
            Database database = Database.getInstance();
            stage.setScene(welcome_scene);
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


