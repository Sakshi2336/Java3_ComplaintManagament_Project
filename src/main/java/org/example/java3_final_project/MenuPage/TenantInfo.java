package org.example.java3_final_project.MenuPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.example.java3_final_project.pojo.DisplayTenant;
import org.example.java3_final_project.pojo.FlatUser;
import org.example.java3_final_project.pojo.User;
import org.example.java3_final_project.tables.FlatUserTable;
import org.example.java3_final_project.tables.UserTable;

import static org.example.java3_final_project.MenuPage.AddComplaintTab.tenant_Combo;

public class TenantInfo extends Tab {

    private TableView tableView;
    private UserTable userTable;
    private FlatUserTable flatUserTable;

    public TenantInfo() {

        this.setText("Tenant Information");

        userTable = new UserTable();
        flatUserTable = new FlatUserTable();
        BorderPane root = new BorderPane();
        HBox hbox = new HBox();
        DisplayTenant displayTenant = new DisplayTenant();

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
            DisplayTenant selectedTenant = (DisplayTenant) tableView.getSelectionModel().getSelectedItem();
            System.out.println(selectedTenant.getId());
                userTable.deleteTenantFromFlatUser(selectedTenant.getId());
                userTable.deleteTenantFromUsers(selectedTenant.getId());
                refreshTable();
                updateTenantComboBox(tenant_Combo,userTable);

        });

        // Refresh Table Button
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> refreshTable());

        // HBox for buttons
        hbox.getChildren().addAll(removeTenantButton, refreshButton);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        root.setCenter(tableView);
        root.setBottom(hbox);
        this.setContent(root);
    }


    // Method to refresh table content
    public void refreshTable() {
        tableView.getItems().clear();
        tableView.getItems().addAll(userTable.getPrettyTenants());
    }

    public void updateTenantComboBox(ComboBox<User> tenant_Combo, UserTable userTable){
        tenant_Combo.setItems(FXCollections.observableArrayList(userTable.getAllUser()));
    }




}

