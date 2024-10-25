package org.example.java3_final_project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This is a basic layout for our update form, I will add Css to this later on.
 * I used gridPane as root node and also add vertical and horizontal gap to it.
 * Have labels and textfields for name, number Info, etc.
 */


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
        grid.add(complaintCategoryCombo, 1, 3);


        Label descriptionLabel = new Label("Description:");
        grid.add(descriptionLabel, 0, 4);
        TextArea descriptionArea = new TextArea();
        grid.add(descriptionArea, 1, 4);

        Label statusLabel = new Label("Status:");
        grid.add(statusLabel, 0, 5);
        ComboBox<String> statusCombo = new ComboBox<>();
        statusCombo.getItems().addAll("Open", "Close");
        grid.add(statusCombo, 1, 5);

        Label assignedManagerLabel = new Label("Assigned Manager:");
        grid.add(assignedManagerLabel, 0, 6);
        ComboBox<String> managerCombo = new ComboBox<>();
        managerCombo.getItems().addAll("Manager 1", "Manager 2", "Manager 3");
        grid.add(managerCombo, 1, 6);


        Label submitDateLabel = new Label("Submit Date:");
        grid.add(submitDateLabel, 0, 7);
        DatePicker submitDatePicker = new DatePicker();
        grid.add(submitDatePicker, 1, 7);


        Button updateButton = new Button("Update");
        grid.add(updateButton, 0, 8);
        Button deleteButton = new Button("Delete");
        grid.add(deleteButton, 1, 8);



        //For now just showing on the message for confirmation later on Will connect it with the database
        updateButton.setOnAction(e -> {
            System.out.println("Update button clicked!");
        });

        deleteButton.setOnAction(e -> {
            System.out.println("Delete button clicked!");
        });


        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();





    }

    public static void main(String[] args) {
        launch(args);
    }


    }

