package org.example.java3_final_project;

import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ViewStatisticsTab extends Tab {

    public ViewStatisticsTab(){
        this.setText("View Statistics");
        Text text = new Text("View Tab is working!");
        BorderPane root = new BorderPane();
        root.setCenter(text);
        this.setContent(root);
    }
}
