package org.example.java3_final_project.MenuPage;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import org.example.java3_final_project.pojo.*;
import org.example.java3_final_project.tables.CategoryTable;
import org.example.java3_final_project.tables.ComplaintTable;
import org.example.java3_final_project.tables.FlatTable;
import org.example.java3_final_project.tables.UserTable;

import java.util.ArrayList;

import static org.example.java3_final_project.database.DBConst.*;
import static org.example.java3_final_project.database.DBConst.COMPLAINT_COLUMN_SUBMIT_TIME;

public class UpdateComplaintTab extends GridPane {
    public int find(ArrayList<?> arrayList, int id) {
        ArrayList<DatabaseComplaint> searchList = (ArrayList<DatabaseComplaint>) (ArrayList<?>) arrayList;
        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).getId() == id) {
              return i;
            }
        }
        return 0;
 }

 public UpdateComplaintTab(Complaint complaint) {
    this.setPadding(new Insets(10, 10, 10, 10));
    this.setVgap(10);
    this.setHgap(10);

    ComplaintTable complaintTable = new ComplaintTable();
    UserTable userTable = new UserTable();
    FlatTable flatTable = new FlatTable();
    CategoryTable categoryTable = new CategoryTable();
    ComplaintCategory complaintCategory = new ComplaintCategory();

    // Tenant Info
    Text tenantInfoHeading = new Text("Tenant Info");
    tenantInfoHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
    this.add(tenantInfoHeading, 0, 0);

    // Tenant name label and combo box
    Label tenantName = new Label("Tenant Name:");
    TextField tenantNameTextField = new TextField();
    tenantNameTextField.setText(String.valueOf(complaint.getUser_id()));
    this.add(tenantName, 0, 1);
    this.add(tenantNameTextField, 1, 1);

    // Flat number label and combo box
    Label flatNumber = new Label("Flat Number:");
    TextField flatNumberTextField = new TextField();
    flatNumberTextField.setText(String.valueOf(complaint.getFlat_num()));
    this.add(flatNumber, 0, 2);
    this.add(flatNumberTextField, 1, 2);

    // Complaint Info
    Text complaintInfoHeading = new Text("Complaint Details");
    complaintInfoHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
    this.add(complaintInfoHeading, 0, 3);

    // Category label and combo box
    Label complaintCategoryLabel = new Label("Complaint Category:");
    ComboBox<Category> categoryComboBox = new ComboBox<>();
    ArrayList<Category> allCategory = categoryTable.getAllCategory();
    categoryComboBox.setItems(FXCollections.observableArrayList(allCategory));
    //categoryComboBox.getSelectionModel().select(find(allCategory,complaintCategory.getCategory_id()));
    this.add(complaintCategoryLabel, 0, 4);
    this.add(categoryComboBox, 1, 4);

    // Description label and text area
    Label description = new Label("Description:");
    TextArea descriptionText = new TextArea();
    descriptionText.setText(complaint.getDescription());
    descriptionText.setWrapText(true);
    descriptionText.setPrefWidth(250);
    descriptionText.setPrefHeight(80);
    this.add(description, 0, 5);
    this.add(descriptionText, 1, 5);

    // Status label and combo box
    Label statusLabel = new Label("Status:");
    ComboBox<String> statusComboBox = new ComboBox<>();
    statusComboBox.getItems().addAll("Open", "In Process","Resolved");
    statusComboBox.setValue(complaint.getStatus());
    this.add(statusLabel, 0, 6);
    this.add(statusComboBox, 1, 6);

    // Assigned Manager label and combo box
    Label assignedManagerLabel = new Label("Assigned Manager:");
    ComboBox<User> managerComboBox = new ComboBox<>();
    managerComboBox.setItems(FXCollections.observableArrayList(userTable.getAllManager()));
    managerComboBox.getSelectionModel().select(find(userTable.getAllManager(), complaint.getManager_id())); // Set selected manager
    this.add(assignedManagerLabel, 0, 7);
    this.add(managerComboBox, 1, 7);

    // Update button
    Button updateButton = new Button("Update");
    updateButton.setOnAction(e -> {
     complaint.setManager_id(managerComboBox.getSelectionModel().getSelectedItem().getId());
     complaint.setDescription(descriptionText.getText());
     complaint.setStatus(statusComboBox.getSelectionModel().getSelectedItem());

     // Call updateComplaint method to save changes
     complaintTable.updateComplaint(complaint);

    });

    this.add(updateButton, 1, 8);
 }
}
