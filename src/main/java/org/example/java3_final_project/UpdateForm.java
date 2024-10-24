package org.example.java3_final_project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class UpdateForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Update Complaint");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);


        Label tenantName = new Label("Tenant Name:");
        grid.add(tenantName, 0, 0);

        TextField tenantNameField = new TextField();
        grid.add(tenantNameField, 1, 0);





    }
}
