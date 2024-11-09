package org.example.java3_final_project.MenuPage;

import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ViewComplaintTab extends Tab {

    public ViewComplaintTab(){
        this.setText("View Complaint");
        Text text = new Text("View Tab is working!");
        BorderPane root = new BorderPane();
        root.setCenter(text);
        this.setContent(root);
    }
}
