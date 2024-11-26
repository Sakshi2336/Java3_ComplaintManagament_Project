package org.example.java3_final_project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.java3_final_project.MenuPage.AddComplaintTab;
import org.example.java3_final_project.MenuPage.ViewComplaintTab;
import org.example.java3_final_project.MenuPage.ViewStatisticsTab;

import java.io.IOException;

public class MenuPaged extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Label label = new Label("What do you want to do?");
        label.setFont(Font.font(25));

        TabPane tabpane = new TabPane();

        Tab viewComp = new ViewComplaintTab();

//        viewComp.setOnAction(e-> System.out.println("view complaint"));

        Tab addComp = new AddComplaintTab();
//        addComp.setOnAction(e-> System.out.println("add complaint"));

        Tab viewStat = new ViewStatisticsTab();
//        viewStat.setOnAction(e-> System.out.println("view statistics"));

        tabpane.getTabs().addAll(viewComp, addComp, viewStat);
        tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        HBox hbox = new HBox(label);
        VBox vbox = new VBox(hbox, tabpane);

        BorderPane bp = new BorderPane();
        bp.setCenter(vbox);

        bp.getStyleClass().add("menu-page");

        Scene scene = new Scene(bp, 1100, 600);
//        System.out.println(this.getClass().getResource("main.css").toExternalForm());
        scene.getStylesheets().add(this.getClass().getResource("main.css").toExternalForm());
        stage.setTitle("Menu Page");
        stage.setScene(scene);
        stage.show();

    }
}

