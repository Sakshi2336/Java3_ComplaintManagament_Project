package org.example.java3_final_project;

import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class AddComplaintTab extends Tab {

    public AddComplaintTab(){
        this.setText("Add complaint");
        Text text = new Text("Add Tab is working!");
        BorderPane root = new BorderPane();
        root.setCenter(text);
        this.setContent(root);
    }
}
