package org.example.java3_final_project.MenuPage;


import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.example.java3_final_project.pojo.Category;

import org.example.java3_final_project.tables.CategoryTable;

import org.example.java3_final_project.pojo.ComplaintCategory;
import org.example.java3_final_project.tables.CategoryTable;
import org.example.java3_final_project.tables.ComplaintCategoryTable;
import org.example.java3_final_project.tables.ComplaintTable;

import java.util.ArrayList;

public class ViewStatisticsTab extends Tab {

    private static ViewStatisticsTab instance;
    private PieChart chart;

    private ViewStatisticsTab() {
        this.setText("View Statistics");

        BorderPane root = new BorderPane();
        chart = new PieChart();
        chart.setTitle("Distribution of Complaints by Category");
        chart.setLabelsVisible(true);
        Button refresh  =new Button("Refresh");
        refresh.setOnAction(e->{
            generateChart();
        });
        generateChart();
        root.setCenter(chart);
        root.setBottom(refresh);
        this.setContent(root);

    }


    public void generateChart(){
        ComplaintCategoryTable complaintCategoryTable = new ComplaintCategoryTable();
        CategoryTable categoryTable = new CategoryTable();
        ArrayList<Category> categories = categoryTable.getAllCategory();
        ArrayList<PieChart.Data> data = new ArrayList<>();
        for(Category category : categories){
            double count = complaintCategoryTable.countComplaintByCategory(category.getId());
            if(count > 0) {
                data.add(new PieChart.Data(category.getName(), count));
            }
        }
        ObservableList<PieChart.Data> chartData
                = FXCollections.observableArrayList(data);
        chart.setData(chartData);
    }

    public static ViewStatisticsTab getInstance() {
        if(instance == null){
            instance = new ViewStatisticsTab();
        }
        return instance;
    }
}
