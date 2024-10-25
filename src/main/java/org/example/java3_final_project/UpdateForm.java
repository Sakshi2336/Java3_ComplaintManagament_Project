package org.example.java3_final_project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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

        Label flatNumberLabel = new Label("Flat Number:");
        grid.add(flatNumberLabel, 0, 1);
        TextField flatNumberField = new TextField();
        grid.add(flatNumberField, 1, 1);

        Label contactInfoLabel = new Label("Contact Information:");
        grid.add(contactInfoLabel, 0, 2);
        TextField contactInfoField = new TextField();
        grid.add(contactInfoField, 1, 2);

        Label complaintCategoryLabel = new Label("Complaint Category:");
        grid.add(complaintCategoryLabel, 0, 3);
        ComboBox<String> complaintCategoryCombo = new ComboBox<>();
        complaintCategoryCombo.getItems().addAll("Plumbing", "Electrical", "Pest Control", "Heating", "other");
        grid.add(complaintCategoryCombo, 1, 3);x




    }


    }

