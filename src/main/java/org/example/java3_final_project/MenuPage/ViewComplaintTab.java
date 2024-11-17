package org.example.java3_final_project.MenuPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.example.java3_final_project.pojo.Complaint;

public class ViewComplaintTab extends Tab {

    private static ViewComplaintTab instance;

    public TableView tableView;
    private ViewComplaintTab() {
        this.setText("View Complaints");
        Complaint complaint = new Complaint();
        BorderPane root = new BorderPane();
        tableView = new TableView();
        //COIN NAME
        TableColumn<DisplayItem, String> column1 =
                new TableColumn<>("Coin Name");

        column1.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getName()));
        //COIN CONDITION
        TableColumn<DisplayItem, String> column2 =
                new TableColumn<>("Coin Condition");

        column2.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getCondition()));

        TableColumn<DisplayItem, String> column3 =
                new TableColumn<>("Coin Year");

        column3.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getYear()));

        TableColumn<DisplayItem, String> column4 =
                new TableColumn<>("Coin Location");

        column4.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getLocation()));

        tableView.getColumns().addAll(column1, column2, column3, column4);
        tableView.getItems().addAll(item.getPrettyItems());
        root.setCenter(tableView);
        Button removeItem = new Button("Remove Item");
        removeItem.setOnAction(e->{
            DisplayItem remove = (DisplayItem) tableView.getSelectionModel().getSelectedItem();
            item.deleteItem(remove.getId());
            refreshTable();
            tableView.getItems().clear();;
            tableView.getItems().addAll(item.getPrettyItems());
            StatisticsTab.getInstance().generateChart();
        });

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(newValue != null){
                    Item selectedItem = item.getItem(((DisplayItem) newValue).getId());
                    //Item object version of DisplayItem (Selected in table)
                    UpdateItemPane pane = new UpdateItemPane(selectedItem);
                    root.setRight(pane);
                }
            }
        });
        root.setBottom(removeItem);
        this.setContent(root);
    }

}
