package org.example.java3_final_project.Tabs;


import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import org.example.java3_final_project.pojo.Category;

import org.example.java3_final_project.tables.CategoryTable;

import org.example.java3_final_project.tables.ComplaintCategoryTable;

import java.util.ArrayList;

/**
 * This tab is for showing statistics for complaints in each category.
 * A pie chart showing the distribution of complaints by category.
 * It gets complaint data from the database and generates a pie chart
 * representing the number of complaints for each category.
 * <p>
 * This tab includes the following components:
 * <ul>
 *     <li>A pie chart that shows the distribution of complaints by category.</li>
 *     <li>A "Refresh" button that updates the chart when clicked.</li>
 * </ul>
 * </p>
 * <p>
 * The chart is updated by querying the database for the complaint counts
 * in each category, and the data is dynamically displayed.
 * </p>
 */

public class ViewStatisticsTab extends Tab {


    //Class members -Class instance and PieChart
    private static ViewStatisticsTab instance;
    private PieChart chart;


    //private constructor
    private ViewStatisticsTab() {
        this.setText("View Statistics");

        //Root pane - BorderPane
        BorderPane root = new BorderPane();

        //Creating new pie chart with title and setting label to visible
        chart = new PieChart();
        chart.setTitle("Distribution of Complaints by Category");
        chart.setLabelsVisible(true);

        //Refresh button
        Button refresh_button  =new Button("Refresh");
        refresh_button.setOnAction(e->{
            generateChart();
        });
        generateChart();
        root.setCenter(chart);
        root.setBottom(refresh_button);
        BorderPane.setMargin(refresh_button,new Insets(0,0,0,600));
        this.setContent(root);

    }


    /**
     * Generates the pie chart by querying the database for complaint counts
     * per category, and populates the chart with this data.
     * The chart data is dynamically loaded based on the categories and
     * the number of complaints in each category.
     */
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


    //getter for class instance

    public static ViewStatisticsTab getInstance() {
        if(instance == null){
            instance = new ViewStatisticsTab();
        }
        return instance;
    }
}
