package org.example.java3_final_project.MenuPage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.example.java3_final_project.pojo.Category;
import org.example.java3_final_project.pojo.Complaint;
import org.example.java3_final_project.pojo.Flat;
import org.example.java3_final_project.pojo.User;
import org.example.java3_final_project.tables.CategoryTable;
import org.example.java3_final_project.tables.ComplaintTable;
import org.example.java3_final_project.tables.FlatTable;
import org.example.java3_final_project.tables.UserTable;

import static javafx.collections.FXCollections.observableArrayList;

public class AddComplaintTab extends Tab {
    public AddComplaintTab(){


        //Tab text
        this.setText("Add complaint");


        //Root panes
        BorderPane root = new BorderPane();
        GridPane tenantPane = new GridPane();
        Text messageText = new Text();

        UserTable userTable = new UserTable();
        ComplaintTable complaintTable = new ComplaintTable();
        FlatTable flatTable = new FlatTable();

        //First tenant information heading
        Text tenantInfoHeading = new Text("Tenant Info");
        tenantInfoHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,30));
        tenantPane.add(tenantInfoHeading,0,2);


        //Tenant name label and text field
        //Now here I need to check if user entered tenant name is valid or not
        Label tenantName = new Label("Tenant Name:");
        tenantPane.add(tenantName, 10, 4);
        ComboBox<User> tenant_Combo = new ComboBox<>();
        tenant_Combo.setItems(FXCollections.observableArrayList(userTable.getAllUser()));
        tenantPane.add(tenant_Combo, 13, 4);

        //Flat number label and combo box where calling getAllFlat method
        Label flatNumber = new Label("Flat Number:");
        ComboBox<Flat> comboFlat = new ComboBox<>();
        comboFlat.setItems(FXCollections.observableArrayList(flatTable.getAllFlat()));
        comboFlat.getSelectionModel().select(0);
        tenantPane.add(flatNumber, 10, 5);
        tenantPane.add(comboFlat, 13, 5);

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

//        ListView<Category> categoryListView = new ListView<>();
//        categoryListView.setItems(FXCollections.observableArrayList(categoryTable.getAllCategory()));
//        categoryListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        complaintPane.add(categoryListView, 1, 1);
//
//        ObservableList<Category> selectedCategories = FXCollections.observableArrayList();
//        ListView<Category> selectedCategoriesListView = new ListView<>(selectedCategories);
//        complaintPane.add(selectedCategoriesListView, 2, 2);


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
        ComboBox<User> managerComboBox = new ComboBox<>();
        managerComboBox.setItems(FXCollections.observableArrayList(userTable.getAllManager()));
        managerComboBox.getSelectionModel().select(0);
        complaintPane.add(managerComboBox, 1, 4);




        //Buttons and hBox to put these buttons
        VBox buttons = new VBox();
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e->{
            Complaint complaint = new Complaint(
                    descriptionText.getText(),
                    statusComboBox.getSelectionModel().getSelectedItem(),
                    tenant_Combo.getSelectionModel().getSelectedItem().getId(),
                    comboFlat.getSelectionModel().getSelectedItem().getFlat_num(),
                    managerComboBox.getSelectionModel().getSelectedItem().getId()
            );
            messageText.setText("Complaint Added!");
            complaintTable.createComplaint(complaint);
            tenant_Combo.setValue(null);
            comboFlat.setValue(null);
            comboCategory.setValue(null);
            descriptionText.setText("");
            managerComboBox.setValue(null);

        });
        buttons.getChildren().addAll(submitButton,messageText);
        messageText.setText("");

        root.setTop(tenantPane);
        root.setCenter(complaintPane);
        root.setBottom(buttons);
        buttons.setAlignment(Pos.BOTTOM_CENTER);

        this.setContent(root);

    }
}










