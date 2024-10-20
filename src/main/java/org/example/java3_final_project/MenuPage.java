package org.example.java3_final_project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Label label = new Label("What do you want to do?");
        label.setFont(Font.font(25));

        TabPane tabpane = new TabPane();

        Tab ViewComplaintTab = new ViewComplaintTab();
//        viewComp.setOnAction(e-> System.out.println("view complaint"));

        Tab addComp = new Tab("Add New Complaints");
//        addComp.setOnAction(e-> System.out.println("add complaint"));

        Tab viewStat = new Tab("View Statistics");
//        viewStat.setOnAction(e-> System.out.println("view statistics"));

        tabpane.getTabs().addAll(viewComp, addComp, viewStat);

        HBox hbox = new HBox(label);
        VBox vbox = new VBox(label, tabpane);
        BorderPane organise = new BorderPane();
        organise.getChildren().setAll(hbox, vbox);

        Scene scene = new Scene(organise, 500, 500);
        stage.setTitle("Menu Page");
        stage.setScene(scene);
        stage.show();

    }
}

public class viewComplaintTab extends Tab{

    public ViewComplaintTab(){
        this.setText("View Complaint");
    }
}

public class AddComplaintTab extends Tab{

    public AddComplaintTab(){
        this.setText("Add complaint");
    }
}

public class ViewStatisticsTab extends Tab{

    public ViewStatisticsTab(){
        this.setText("View Statistics");
    }
}