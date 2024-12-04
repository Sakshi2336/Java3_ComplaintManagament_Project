package org.example.java3_final_project.Tabs;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.example.java3_final_project.pojo.DisplayTenant;
import org.example.java3_final_project.pojo.User;
import org.example.java3_final_project.tables.FlatUserTable;
import org.example.java3_final_project.tables.UserTable;

import static org.example.java3_final_project.Tabs.AddComplaintTab.tenant_Combo;


/**
 * The TenantInfo class shows tenant information.
 * It allows the manager to view, remove, and refresh the list of tenants.
 */

public class TenantInfo extends Tab {


    //class members
    private TableView tableView;
    private UserTable userTable;
    private FlatUserTable flatUserTable;

    public TenantInfo() {

        //tab label
        this.setText("Tenant Information");

        //All needed tables
        userTable = new UserTable();
        flatUserTable = new FlatUserTable();

        //Root pane BorderPane
        BorderPane root = new BorderPane();

        //Sub layout Hbox
        HBox hbox = new HBox();

        //Text object for showing user message and font size for that text object
        Text messageText = new Text();
        messageText.setFont(Font.font(20));


        //TableView for showing tenant information and all 3 columns for flat num, first name and last name
        tableView = new TableView();

        // Tenant First Name
        TableColumn<DisplayTenant, String> column1 =
                new TableColumn<>("First Name");

        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getFirst_name()));

        // Tenant Last Name
        TableColumn<DisplayTenant, String> column2 =
                new TableColumn<>("Last Name");

        column2.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getLast_name()));

        // Tenant Apartment Number
        TableColumn<DisplayTenant, String> column3 =
                new TableColumn<>("Apartment Number");
        column3.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getFlat_num()));


        tableView.getColumns().addAll(column1, column2, column3);
        tableView.getItems().addAll(userTable.getPrettyTenants());
        root.setCenter(tableView);


        // Remove Tenant Button
        Button removeTenantButton = new Button("Remove Tenant");
        removeTenantButton.setOnAction(e -> {
            //converting selected item to DisplayTenant
            DisplayTenant selectedTenant = (DisplayTenant) tableView.getSelectionModel().getSelectedItem();
            if(selectedTenant == null){ //if user do not select anything then shoeing message
                messageText.setText("Please first select tenant.");
            }else {
                //deleting user first from FlatUser table
                userTable.deleteTenantFromFlatUser(selectedTenant.getId());
                //Then deleting from Users class but cannot do that as user id is in complaint table
                //userTable.deleteTenantFromUsers(selectedTenant.getId());
                //showing message to user
                messageText.setText("Tenant Removed Successfully");
                //After deleting user refreshing table view
                refreshTable();
                //Then updating tenant combo box in add complaint table so
                // when manager delete user from table it will also get removed
                // from add complaint tenant combo box which is displaying
                // all users living in apartment
                updateTenantComboBox(tenant_Combo, userTable);
            }
        });

        // Refresh Table Button
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> refreshTable());

        // HBox for buttons
        hbox.getChildren().addAll(removeTenantButton, refreshButton,messageText);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        root.setCenter(tableView);
        root.setBottom(hbox);
        this.setContent(root);
    }


    /**
     * Refresh the tenant table by clearing its current items and adding
     * the updated items in the table.
     */
    public void refreshTable() {
        tableView.getItems().clear();
        tableView.getItems().addAll(userTable.getPrettyTenants());
    }

    /**
     * This method update the tenant combo box which is showing users living in
     * the apartment.
     * @param tenant_Combo -> combo box of tenants
     * @param userTable -> User Table for calling getAllUser method
     */
    public void updateTenantComboBox(ComboBox<User> tenant_Combo, UserTable userTable){
        tenant_Combo.setItems(FXCollections.observableArrayList(userTable.getAllUser()));
    }




}

