package org.example.java3_final_project.MenuPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.example.java3_final_project.pojo.DisplayTenant;
import org.example.java3_final_project.tables.ComplaintTable;
import org.example.java3_final_project.tables.UserTable;

public class TenentInfo extends Tab {

    public TableView tableView;
    public UserTable tenantTable;

    public TenentInfo() {

        this.setText("Tenant Information");

        tenantTable = new UserTable();
        BorderPane root = new BorderPane();
        HBox hbox = new HBox();

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
        tableView.getItems().addAll(tenantTable.getPrettyTenants());
        root.setCenter(tableView);
        root.setBottom(hbox);
        this.setContent(root);

}
}
