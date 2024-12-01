package org.example.java3_final_project.Tabs;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import org.example.java3_final_project.pojo.*;
import org.example.java3_final_project.tables.*;


/**
 * The AddComplaintTab class represents a tab within the application that allows users to
 * add a new complaint. This tab contains various fields where users can input tenant information,
 * complaint details, and assign a manager to the complaint. It includes a form where users can select
 * a tenant, flat number, complaint category, and manager, as well as provide a description for the complaint.
 * The form is submitted by clicking a submit button, which saves the complaint and resets the form.
 *
 * <p>This tab also displays a success message when the complaint is successfully added.</p>
 */

public class AddComplaintTab extends Tab {


    //class member ComboBox-> Make it class member so that i can use it into remove tab to refresh tha tenant information
    public static ComboBox<User> tenant_Combo = new ComboBox<>();

    //public constructor
    public AddComplaintTab(){
        //Tab text
        this.setText("Add complaint");


        //Root pane - BorderPane
        BorderPane root = new BorderPane();
        root.getStyleClass().add("addCompRoot");

        GridPane tenantPane = new GridPane();
        tenantPane.setHgap(10);
        tenantPane.setVgap(3);
        tenantPane.getStyleClass().add("tenant-section");


        //Text object to show message when complaint successfully added into database
        Text messageText = new Text();

        //All tables
        UserTable userTable = new UserTable();
        ComplaintTable complaintTable = new ComplaintTable();
        FlatTable flatTable = new FlatTable();
        ComplaintCategoryTable complaintCategoryTable = new ComplaintCategoryTable();

        //First tenant information heading
        Text tenantInfoHeading = new Text("Tenant Info");
        tenantPane.add(tenantInfoHeading,10,1); //colum,row,col span,row span
        tenantInfoHeading.getStyleClass().add("tenantHeading");

        //Tenant name label and text field
        Label tenantName = new Label("Tenant Name:");
        tenantPane.add(tenantName, 10, 7);
        tenant_Combo = new ComboBox<>();
        tenant_Combo.setItems(FXCollections.observableArrayList(userTable.getAllUser()));
        tenantPane.add(tenant_Combo, 17, 7);

        //Flat number label and combo box where calling getAllFlat method
        Label flatNumber = new Label("Flat Number:");
        ComboBox<Flat> comboFlat = new ComboBox<>();
        comboFlat.setItems(FXCollections.observableArrayList(flatTable.getAllFlat()));
        comboFlat.getSelectionModel().select(0);
        tenantPane.add(flatNumber, 10, 13);
        tenantPane.add(comboFlat, 17, 13);

        //sub grid pane for complaint information
        GridPane complaintPane = new GridPane();
        complaintPane.getStyleClass().add("complaint-section");
        complaintPane.setHgap(10);
        complaintPane.setVgap(3);

        //Second heading complaint information
        Text complaintDetailHeading = new Text("Complaint Details");
        complaintDetailHeading.getStyleClass().add("compHeading");
        complaintPane.add(complaintDetailHeading, 10, 1);

        //Category label and combo box
        Label complaintCategory = new Label("Complaint Category:");
        complaintPane.add(complaintCategory, 10, 7);
        CategoryTable categoryTable = new CategoryTable();
        ComboBox<Category> comboCategory = new ComboBox<>();
        comboCategory.setItems(FXCollections.observableArrayList(categoryTable.getAllCategory()));
        comboCategory.getSelectionModel().select(0);
        complaintPane.add(comboCategory, 17, 7);


        //Complaint description
        Label description = new Label("Description:");
        complaintPane.add(description, 10, 13);
        TextArea descriptionText = new TextArea();
        descriptionText.setWrapText(true);
        descriptionText.setPrefWidth(250);
        descriptionText.setPrefHeight(80);
        complaintPane.add(descriptionText, 17, 13);


        //Status label and combo box
        Label status = new Label("Status:");
        complaintPane.add(status, 25, 7);
        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Open","in Process");
        statusComboBox.setValue("Open");
        complaintPane.add(statusComboBox, 32, 7);


        //Assigned manager label and combo box
        Label assignedManager = new Label("Assigned Manager:");
        complaintPane.add(assignedManager, 25, 13);
        ComboBox<User> managerComboBox = new ComboBox<>();
        managerComboBox.setItems(FXCollections.observableArrayList(userTable.getAllManager()));
        managerComboBox.getSelectionModel().select(0);
        complaintPane.add(managerComboBox, 32, 13);




        //Buttons and hBox to put these buttons
        HBox buttons_hbox = new HBox(5);
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
        buttons_hbox.getChildren().addAll(submitButton,messageText);
        messageText.setText("");

        root.setTop(tenantPane);
        root.setCenter(complaintPane);
        BorderPane.setMargin(complaintPane,new Insets(10,0,0,0));
        root.setBottom(buttons_hbox);
        buttons_hbox.setAlignment(Pos.BOTTOM_CENTER);


        this.setContent(root);

    }

}










