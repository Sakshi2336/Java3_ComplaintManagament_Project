package org.example.java3_final_project.Tabs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.java3_final_project.WelcomePage;

import java.io.IOException;
import java.util.Objects;

public class MenuPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Label label = new Label("What do you want to do?");
        label.setFont(Font.font(25));

        TabPane tabpane = new TabPane();

        Tab viewComp = new ViewComplaintTab();

        Tab addComp = new AddComplaintTab();

        Tab viewStat = ViewStatisticsTab.getInstance();

        Tab tenantInfo = new TenantInfo();

        Tab goBack = new Tab("Go Back");

        tabpane.getTabs().addAll(viewComp, addComp, viewStat,tenantInfo,goBack);

        tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        HBox hbox = new HBox(label);
        hbox.setAlignment(Pos.CENTER);
        hbox.getStyleClass().add("mainLabelHBox");

        HBox tabPaneHbox = new HBox(tabpane);
        tabPaneHbox.setAlignment(Pos.CENTER);
        tabPaneHbox.setStyle("-fx-padding: 20px;");

        VBox vbox = new VBox(20, hbox, tabPaneHbox);
        vbox.setAlignment(Pos.CENTER);

        BorderPane bp = new BorderPane();
        bp.setCenter(vbox);

        bp.getStyleClass().add("menu-page");

        Scene scene = new Scene(bp, 1500, 750);
        scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/org/example/java3_final_project/main.css")).toExternalForm());
        stage.setTitle("Menu Page");
        stage.setScene(scene);
        stage.show();




    }
}

