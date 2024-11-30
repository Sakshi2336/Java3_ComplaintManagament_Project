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
import javafx.stage.Stage;
import org.example.java3_final_project.WelcomePage;

import java.io.IOException;
import java.util.Objects;

/**
 * The MenuPage class shows the main menu of the Apartment Complaint Management System.
 * This is shown to the user after the welcome page. This page allows manager
 * to navigate through various sections like viewing complaints, adding complaints,
 * viewing statistics, and seeing tenant information.
 *
 * <p>The layout of the MenuPage have the following components:</p>
 * <ul>
 *     <li>A title label ("Manage Apartment Complaints With Ease") at the top of the page.</li>
 *     <li>A TabPane containing tabs for:
 *         <ul>
 *             <li>Viewing complaints.</li>
 *             <li>Adding complaints.</li>
 *             <li>Viewing statistics.</li>
 *             <li>Viewing tenant information.</li>
 *             <li>A "Go Back" tab to navigate to the previous screen.</li>
 *         </ul>
 *     </li>
 *     <li>Styling applied through an external CSS file</li>
 * </ul>
 */
public class MenuPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //Label for title of the MenuPage
        Label label = new Label("Manage Apartment Complaints With Ease");
        label.getStyleClass().add("title");

        //TabPane and all the tabs
        TabPane tabpane = new TabPane();

        Tab viewComp = new ViewComplaintTab();
        Tab addComp = new AddComplaintTab();
        Tab viewStat = ViewStatisticsTab.getInstance();
        Tab tenantInfo = new TenantInfo();
        Tab goBack = new Tab("Go Back");
        tabpane.getTabs().addAll(viewComp, addComp, viewStat,tenantInfo,goBack);
        tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        goBack.setOnSelectionChanged(e->{
            WelcomePage welcomePage = new WelcomePage();
            try {
                welcomePage.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        //Sub Layouts
        HBox hbox = new HBox(label);

        HBox tabPaneHbox = new HBox(tabpane);
        tabPaneHbox.setAlignment(Pos.CENTER);
        tabPaneHbox.setStyle("-fx-padding: 20px;");

        VBox vbox = new VBox(20, hbox, tabPaneHbox);
        vbox.setAlignment(Pos.CENTER);


        //Root pane - BorderPane
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

