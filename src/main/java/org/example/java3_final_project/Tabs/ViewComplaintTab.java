package org.example.java3_final_project.Tabs;

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
import org.example.java3_final_project.pojo.Complaint;
import org.example.java3_final_project.pojo.DisplayComplaint;
import org.example.java3_final_project.tables.ComplaintTable;

/**
 * The ViewComplaintTab class represents a tab within the application where users can view a list of complaints.
 * It displays complaints in a TableView with several columns, such as complaint description, submission time, status,
 * tenant name, flat number, and assigned manager. The tab also includes buttons to refresh the complaint data
 * or view only open complaints.
 *
 * <p>This tab listens for selections from the TableView and opens an UpdateComplaintTab to allow the user
 * to update the selected complaint details.</p>
 */
public class ViewComplaintTab extends Tab {

    //class members
    private TableView tableView;
    private ComplaintTable complaint;

    //Public constructor
    public ViewComplaintTab() {

        //Root Pane - BorderPane
        BorderPane root = new BorderPane();
        root.getStyleClass().add("ViewComplaintRoot");

        //Sub Layout hBox for buttons
        HBox hbox = new HBox();

        //Tables
        complaint = new ComplaintTable();

        //Tableview and columns of the table
        tableView = new TableView();
        //Complaint Description
        TableColumn<DisplayComplaint, String> column1 =
                new TableColumn<>("Complaint Description");
        column1.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getDescription()));

        //Complaint Submit time
        TableColumn<DisplayComplaint, String> column2 =
                new TableColumn<>("Submit Time");
        column2.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getSubmit_time()));


        //Complaint status-open,resolved,in Process
        TableColumn<DisplayComplaint, String> column3 =
                new TableColumn<>("Status");
        column3.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getStatus()));


        //Tenant name for registered complaint
        TableColumn<DisplayComplaint, String> column4 =
                new TableColumn<>("Tenant Name");
        column4.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getTenant_name()));


        //Flat number
        TableColumn<DisplayComplaint, String> column5 =
                new TableColumn<>("Flat Number");
        column5.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getFlat_num()));


        //Assigned manager for particular complaint
        TableColumn<DisplayComplaint, String> column6 =
                new TableColumn<>("Assigned Manager");
        column6.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getManager_name()));


        //tableview all columns
        tableView.getColumns().addAll(column1, column2, column3, column4,column5,column6);
        tableView.getItems().addAll(complaint.getPrettyComplaints());

        //Buttons
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> {
            refreshTable();
        });
        Button openComplaints = new Button("Open Complaints");
        openComplaints.setOnAction(e -> {
            seeOpenComplaints();});

        //Sub layout children
        hbox.getChildren().addAll(refreshButton,openComplaints);

        //Root pane children
        root.setCenter(tableView);
        root.setBottom(hbox);
        this.setContent(root);


        //Adding listener on tableview that will show update form
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                if(newValue != null){
                    Complaint selectedItem = complaint.getComplaint(((DisplayComplaint) newValue).getId());
                    System.out.println(selectedItem.getDescription());
                    UpdateComplaintTab pane = new UpdateComplaintTab(selectedItem);
                    root.setRight(pane);
                }
                else{
                    System.out.println("Listener is having issue");
                }
            }
        });

        //Tab label
        this.setText("View Complaints");
    }

    /**
     * Refreshes the table view by clearing its current items and reloading the
     * list of complaints from the database table.
     * This method calls the `getPrettyComplaints()` method from the `ComplaintTable`
     * class to get and display the updated list of complaints.
     */
    public void refreshTable(){
        ComplaintTable table = new ComplaintTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.getPrettyComplaints());
    }


    /**
     * Displays only the open complaints in the table by clearing the current items
     * and adding the open complaints to the table view.
     * This method calls the `openComplaints()` method from the `ComplaintTable`
     * class to get and display the list of complaints that are still open.
     */
    public void seeOpenComplaints(){
        ComplaintTable table = new ComplaintTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.openComplaints());
    }







}
