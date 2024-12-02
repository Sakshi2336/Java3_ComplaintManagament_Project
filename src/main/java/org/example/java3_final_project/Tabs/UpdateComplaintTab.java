package org.example.java3_final_project.Tabs;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import org.example.java3_final_project.pojo.*;
import org.example.java3_final_project.tables.*;

import java.util.ArrayList;

/**
 * The UpdateComplaintTab class extends GridPane, is an update form to update complaint information.
 * This form will allow the user to update complaint description, the assigned manager, and status.
 */

public class UpdateComplaintTab extends GridPane {

    /**
     * This method will find the particular id into ArrayList which is passed as
     * parameter
     * @param arrayList -> ArrayList in which searching for passed id
     * @param id -> id that need to find in ArrayList
     * @return the index of the complaint in the list if found , otherwise return 0.
     */
    public int find(ArrayList<?> arrayList, int id) {
        ArrayList<DatabaseComplaint> searchList = (ArrayList<DatabaseComplaint>) (ArrayList<?>) arrayList;
        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).getId() == id) {
              return i;
            }
        }
        return 0;
 }


    /**
     * Constructs a new UpdateComplaintTab that displays the current details of a complaint,
     * allowing the user to modify data for particular complaint such as
     * manager, status, and description.
     * @param complaint the complaint object that will be updated
     */
 public UpdateComplaintTab(Complaint complaint) {

     //Class member ViewComplaintTab class object to call refresh method
     ViewComplaintTab viewComplaintTab = new ViewComplaintTab();

     //Adding class to this class and setting up padding and HGap,VGap
    this.getStyleClass().add("updateRoot");
    this.setPadding(new Insets(10, 10, 10, 10));
    this.setVgap(10);
    this.setHgap(10);

    //All needed table and text object for showing message to the user
    ComplaintTable complaintTable = new ComplaintTable();
    UserTable userTable = new UserTable();
    CategoryTable categoryTable = new CategoryTable();
    ComplaintCategoryTable complaintCategoryTable = new ComplaintCategoryTable();
    Text message_text = new Text();

    // Tenant Info Text
    Text tenantInfoHeading = new Text("Tenant Info");
    tenantInfoHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
    this.add(tenantInfoHeading, 0, 0);

    // Tenant name label and combo box
    Label tenantName = new Label("Tenant Name:");
    TextField tenantNameTextField = new TextField();
    tenantNameTextField.setEditable(false);
    tenantNameTextField.setText(userTable.getUserFirstName(complaint.getUser_id()));
    this.add(tenantName, 0, 1);
    this.add(tenantNameTextField, 1, 1);

    // Flat number label and combo box
    Label flatNumber = new Label("Flat Number:");
    TextField flatNumberTextField = new TextField();
    flatNumberTextField.setEditable(false);
    flatNumberTextField.setText(String.valueOf(complaint.getFlat_num()));
    this.add(flatNumber, 0, 2);
    this.add(flatNumberTextField, 1, 2);

    // Complaint Info Text
    Text complaintInfoHeading = new Text("Complaint Details");
    complaintInfoHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
    this.add(complaintInfoHeading, 0, 3);

    // Category label and combo box
    Label complaintCategoryLabel = new Label("Complaint Category:");
    TextField categoryTextField = new TextField();
    categoryTextField.setEditable(false);
    categoryTextField.setText(categoryTable.getCategory(complaintCategoryTable.getCategoryByComplaint(complaint.getId())));
    this.add(complaintCategoryLabel, 0, 4);
    this.add(categoryTextField, 1, 4);

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
     //set manager id that user will select in update form combo box
     complaint.setManager_id(managerComboBox.getSelectionModel().getSelectedItem().getId());
     //set complaint description that user will update in TextField
     complaint.setDescription(descriptionText.getText());
     //Set complaint status that user will set in Status combo box
     complaint.setStatus(statusComboBox.getSelectionModel().getSelectedItem());

     // Call updateComplaint method to save changes
     complaintTable.updateComplaint(complaint);

     //After complaint update successfully updating table view.
     //This is not working.
     viewComplaintTab.refreshTable();

     //showing message to the user after complaint updated successfully.
     message_text.setText("Complaint updated successfully");
    });

    this.add(updateButton, 1, 8);
    this.add(message_text,1,9);
 }
}
