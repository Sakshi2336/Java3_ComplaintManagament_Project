package org.example.java3_final_project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        System.out.println("What do you want to do?");
        Button viewComp = new Button("View All Complaints");
        Button addComp = new Button("Add New Complaints");
        Button viewStat = new Button("View Statistics");

        VBox organise = new VBox(viewComp, addComp, viewStat);

        Scene scene = new Scene(organise, 500, 600);
        stage.setTitle("Menu Page");
        stage.setScene(scene);
        stage.show();

    }
}
