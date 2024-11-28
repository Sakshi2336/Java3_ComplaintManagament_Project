package org.example.java3_final_project.Tabs;

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
import java.util.Objects;

public class MenuPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Label label = new Label("What do you want to do?");
        label.setFont(Font.font(25));
        //Font font = Font.loadFont(getClass().getResourceAsStream("/Lobster/Lobster-Regular.ttf"),55);

        TabPane tabpane = new TabPane();

        Tab viewComp = new ViewComplaintTab();

        Tab addComp = new AddComplaintTab();

        Tab viewStat = ViewStatisticsTab.getInstance();

        Tab tenantInfo = new TenantInfo();


        tabpane.getTabs().addAll(viewComp, addComp, viewStat,tenantInfo);

        tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        HBox hbox = new HBox(label);
        hbox.getStyleClass().add("viewComp");

        VBox vbox = new VBox(hbox, tabpane);

        BorderPane bp = new BorderPane();
        bp.setCenter(vbox);

        bp.getStyleClass().add("menu-page");

        Scene scene = new Scene(bp, 1100, 600);
        scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/org/example/java3_final_project/main.css")).toExternalForm());
        stage.setTitle("Menu Page");
        stage.setScene(scene);
        stage.show();




    }
}

