package org.example.java3_final_project.MenuPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.example.java3_final_project.pojo.Complaint;
import org.example.java3_final_project.pojo.DisplayComplaint;
import org.example.java3_final_project.tables.ComplaintTable;

public class ViewComplaintTab extends Tab {


    public TableView tableView;
    public ComplaintTable complaint;
    public ViewComplaintTab() {

        this.setText("View Complaints");
        complaint = new ComplaintTable();
        BorderPane root = new BorderPane();
        HBox hbox = new HBox();
        tableView = new TableView();
        //Complaint Description
        TableColumn<DisplayComplaint, String> column1 =
                new TableColumn<>("Complaint Description");

        column1.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getDescription()));
        //Complaint Description
        TableColumn<DisplayComplaint, String> column2 =
                new TableColumn<>("Complaint Submit Time");

        column2.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getSubmit_time()));

        TableColumn<DisplayComplaint, String> column3 =
                new TableColumn<>("Complaint Status");

        column3.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getStatus()));

        TableColumn<DisplayComplaint, String> column4 =
                new TableColumn<>("Complaint Tenant Name");

        column4.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getTenant_name()));

        TableColumn<DisplayComplaint, String> column5 =
                new TableColumn<>("Complaint Flat Number");

        column5.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getFlat_num()));

        TableColumn<DisplayComplaint, String> column6 =
                new TableColumn<>("Complaint Manager Name");

        column6.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getManager_name()));

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> {
            refreshTable();
        });


        hbox.getChildren().addAll(refreshButton);




        tableView.getColumns().addAll(column1, column2, column3, column4,column5,column6);
        tableView.getItems().addAll(complaint.getPrettyComplaints());
        root.setCenter(tableView);
        root.setBottom(hbox);
        this.setContent(root);

    }

    public void refreshTable(){
        ComplaintTable table = new ComplaintTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.getPrettyComplaints());
    }





}
