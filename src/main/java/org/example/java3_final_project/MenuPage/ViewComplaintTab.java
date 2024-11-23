package org.example.java3_final_project.MenuPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
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

        complaint = new ComplaintTable();
        BorderPane root = new BorderPane();
        HBox hbox = new HBox();  this.setText("View Complaints");

        tableView = new TableView();
        //Complaint Description
        TableColumn<DisplayComplaint, String> column1 =
                new TableColumn<>("Complaint Description");

        column1.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getDescription()));
        //Complaint Description
        TableColumn<DisplayComplaint, String> column2 =
                new TableColumn<>("Submit Time");

        column2.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getSubmit_time()));

        TableColumn<DisplayComplaint, String> column3 =
                new TableColumn<>("Status");

        column3.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getStatus()));

        TableColumn<DisplayComplaint, String> column4 =
                new TableColumn<>("Tenant Name");

        column4.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getTenant_name()));

        TableColumn<DisplayComplaint, String> column5 =
                new TableColumn<>("Flat Number");

        column5.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getFlat_num()));

        TableColumn<DisplayComplaint, String> column6 =
                new TableColumn<>("Assigned Manager");

        column6.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getManager_name()));

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> {
            refreshTable();
        });
        Button openComplaints = new Button("Open Complaints");
        openComplaints.setOnAction(e -> {
            seeOpenComplaints();});


        hbox.getChildren().addAll(refreshButton,openComplaints);

        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);




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

    public void seeOpenComplaints(){
        ComplaintTable table = new ComplaintTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.openComplaints());
    }






}
