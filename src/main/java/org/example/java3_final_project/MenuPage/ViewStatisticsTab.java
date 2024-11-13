package org.example.java3_final_project.MenuPage;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ViewStatisticsTab extends Tab {

    private PieChart chart;

    public ViewStatisticsTab(){
        this.setText("View Statistics");
        Text text = new Text("View Tab is working!");
        BorderPane root = new BorderPane();
        chart = new PieChart();
        chart.setTitle("Stats for Complaints");
        Button refresh  =new Button("Refresh");





        root.setCenter(text);
        this.setContent(root);
    }
}
