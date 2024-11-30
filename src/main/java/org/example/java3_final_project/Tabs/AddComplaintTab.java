package org.example.java3_final_project.Tabs;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import org.example.java3_final_project.pojo.*;
import org.example.java3_final_project.tables.*;

import java.util.Objects;

import static javafx.collections.FXCollections.observableArrayList;

public class AddComplaintTab extends Tab {

    public static ComboBox<User> tenant_Combo = new ComboBox<>();
    public AddComplaintTab(){


        //Tab text
        this.setText("Add complaint");


        //Root panes
        BorderPane root = new BorderPane();

        GridPane tenantPane = new GridPane();
        tenantPane.getStyleClass().add("tenant-section");

        Text messageText = new Text();

        UserTable userTable = new UserTable();
        ComplaintTable complaintTable = new ComplaintTable();
        FlatTable flatTable = new FlatTable();
        ComplaintCategoryTable complaintCategoryTable = new ComplaintCategoryTable();

        //First tenant information heading
        Text tenantInfoHeading = new Text("Tenant Info");
        tenantInfoHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,30));
        tenantPane.add(tenantInfoHeading,0,2);


        //Tenant name label and text field
        //Now here I need to check if user entered tenant name is valid or not
        Label tenantName = new Label("Tenant Name:");
        tenantPane.add(tenantName, 10, 4);
        tenant_Combo = new ComboBox<>();
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
        VBox buttons_vbox = new VBox();
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e->{
            Complaint complaint = new Complaint(
                    descriptionText.getText(),
                    statusComboBox.getSelectionModel().getSelectedItem(),
                    tenant_Combo.getSelectionModel().getSelectedItem().getId(),
                    comboFlat.getSelectionModel().getSelectedItem().getFlat_num(),
                    managerComboBox.getSelectionModel().getSelectedItem().getId()
            );
            complaintTable.createComplaint(complaint);
            complaintCategoryTable.insertQuery(comboCategory.getSelectionModel().getSelectedItem().getId());
            messageText.setText("Complaint Added!");
            ViewStatisticsTab.getInstance().generateChart();
            tenant_Combo.setValue(null);
            comboFlat.setValue(null);
            comboCategory.setValue(null);
            descriptionText.setText("");
            managerComboBox.setValue(null);

        });
        buttons_vbox.getChildren().addAll(submitButton,messageText);
        messageText.setText("");

        root.setTop(tenantPane);
        root.setCenter(complaintPane);
        root.setBottom(buttons_vbox);
        buttons_vbox.setAlignment(Pos.BOTTOM_CENTER);


        this.setContent(root);

    }

}










