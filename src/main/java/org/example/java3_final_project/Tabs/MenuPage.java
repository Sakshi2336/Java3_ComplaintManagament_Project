package org.example.java3_final_project.Tabs;

import javafx.application.Application;
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
        //Font font = Font.loadFont(getClass().getResourceAsStream("/Lobster/Lobster-Regular.ttf"),55);

        TabPane tabpane = new TabPane();

        Tab viewComp = new ViewComplaintTab();

        Tab addComp = new AddComplaintTab();

        Tab viewStat = ViewStatisticsTab.getInstance();

        Tab tenantInfo = new TenantInfo();


        tabpane.getTabs().addAll(viewComp, addComp, viewStat,tenantInfo);

        tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Button backButton = new Button("Back to Welcome");
        backButton.setFont(Font.font(18));
        backButton.setOnAction(e -> {
            WelcomePage welcomePage = new WelcomePage(); // Create an instance of WelcomePage
            try {
                welcomePage.start(stage); // Navigate to the WelcomePage
            }catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        HBox hbox = new HBox(10,backButton,label);
        hbox.setStyle("-fx-padding: 10px; -fx-alignment: center-left;");
        hbox.getStyleClass().add("viewComp");

        VBox vbox = new VBox(hbox, tabpane);

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

