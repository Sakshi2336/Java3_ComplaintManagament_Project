package org.example.java3_final_project.MenuPage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.example.java3_final_project.pojo.Category;
import org.example.java3_final_project.pojo.Flat;
import org.example.java3_final_project.tables.CategoryTable;
import org.example.java3_final_project.tables.FlatTable;

import static javafx.collections.FXCollections.observableArrayList;

public class AddComplaintTab extends Tab {

    public AddComplaintTab(){

        //Tab text
        this.setText("Add complaint");


        //Root panes
        BorderPane root = new BorderPane();
        GridPane tenantPane = new GridPane();


        //First tenant information heading
        Text tenantInfoHeading = new Text("Tenant Info");
        tenantInfoHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,30));
        tenantPane.add(tenantInfoHeading, 0, 0);


        //Tenant name label and text field
        Label tenantName = new Label("Tenant Name:");
        tenantPane.add(tenantName, 0, 1);
        TextField tenantNameInput = new TextField();
        tenantPane.add(tenantNameInput, 1, 1);

        //Flat number label and combo box where calling getAllFlat method
        Label flatNumber = new Label("Flat Number:");
        FlatTable flatTable = new FlatTable();
        ComboBox<Flat> comboFlat = new ComboBox<>();
        comboFlat.setItems(FXCollections.observableArrayList(flatTable.getAllFlat()));
        comboFlat.getSelectionModel().select(0);
        tenantPane.add(flatNumber, 0, 2);
        tenantPane.add(comboFlat, 1, 2);

        //sub grid pane for complaint information
        GridPane complaintPane = new GridPane();

        //Second heading complaint information
        Text complaintDetailHeading = new Text("Complaint Details");
        complaintDetailHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,30));
        complaintPane.add(complaintDetailHeading, 0, 0);

        //Category label and combo box
        Label complaintCategory = new Label("Complaint Category:");
        complaintPane.add(complaintCategory, 0, 1);
        CategoryTable categoryTable = new CategoryTable();
        ComboBox<Category> comboCategory = new ComboBox<>();
        comboCategory.setItems(FXCollections.observableArrayList(categoryTable.getAllCategory()));
        comboCategory.getSelectionModel().select(0);
        complaintPane.add(comboCategory, 1, 1);


        //Complaint description
        Label description = new Label("Description:");
        complaintPane.add(description, 0, 2);
        TextArea descriptionText = new TextArea();
        descriptionText.setWrapText(true);
        descriptionText.setPrefWidth(250);
        descriptionText.setPrefHeight(80);
        complaintPane.add(descriptionText, 1, 2);


        //Status label and combo box
        Label status = new Label("Status:");
        complaintPane.add(status, 0, 3);
        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Open","in Process");
        statusComboBox.setValue("Open");
        complaintPane.add(statusComboBox, 1, 3);


        //Assigned manager label and combo box
        Label assignedManager = new Label("Assigned Manager:");
        complaintPane.add(assignedManager, 0, 4);
        ObservableList<String> managers = observableArrayList(
                "Manager 1",
                "Manager 2");
        ComboBox<String> managerComboBox = new ComboBox<>(managers);
        complaintPane.add(managerComboBox, 1, 4);

        HBox buttons = new HBox();

        Button submitButton = new Button("Submit");
//        submitButton.setOnAction(e -> {
//            Text text = new Text("Form Successfully Submitted!");
//        });
        Button cancelButton = new Button("Cancel");
        buttons.getChildren().addAll(submitButton, cancelButton);

        root.setTop(tenantPane);
        root.setCenter(complaintPane);
        root.setBottom(buttons);
        buttons.setAlignment(Pos.BOTTOM_CENTER);

        this.setContent(root);
    }
}
