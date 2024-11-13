package org.example.java3_final_project.MenuPage;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.example.java3_final_project.pojo.Category;
import org.example.java3_final_project.tables.CategoryTable;
import org.example.java3_final_project.tables.ComplaintTable;

import java.util.ArrayList;

public class ViewStatisticsTab extends Tab {

    private PieChart chart;

    public ViewStatisticsTab() {
        this.setText("View Statistics");
        Text text = new Text("View Tab is working!");
        BorderPane root = new BorderPane();
        chart = new PieChart();
        chart.setTitle("Stats for Complaints");
        Button refresh = new Button("Refresh");

        refresh.setOnAction(e -> {
            generateChart();
        });
        generateChart();
        root.setCenter(text);
        this.setContent(root);

    }

    public void generateChart() {


        ComplaintTable complaintTable = new ComplaintTable();
        CategoryTable categoryTable = new CategoryTable();

        // Grab all the complaints from the table
        ArrayList<Category> categories = categoryTable.getAllCategory();
        ArrayList<PieChart.Data> data = new ArrayList<>();



    }
}
