package org.example.java3_final_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Labels for username,password,server location and database name
        Label username_label = new Label("Username:");
        Label password_label = new Label("Password:");
        Label server_label = new Label("Server Location:");
        Label database_label = new Label("Database Name:");

        //sub layout vbox
        VBox vBox = new VBox(username_label,password_label,server_label,database_label);
        vBox.setAlignment(Pos.CENTER);

        //root pane
        BorderPane root = new BorderPane();
        root.setCenter(vBox);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
