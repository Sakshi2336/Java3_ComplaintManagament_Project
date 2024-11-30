package org.example.java3_final_project;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.java3_final_project.Tabs.MenuPage;

import java.io.IOException;
import java.util.Objects;

public class WelcomePage extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        /**
         *  welcome_scene -> welcome page which will show basic information for
         *  our application and have button that will navigate to the main menu page.
         *  This welcome page has:
         *  - text objects -> for welcome , description and end text
         *  - start button -> to navigate to the main menu page
         *  - scale transition for start button
         *  - title_vBox -> to pull all 3 text objects
         *  - button_hBox -> to put start button
         *  - welcome_scene_rootPane -> Borderpane as main root pane
         */

        Text welcome_text = new Text("Welcome to the Apartment Complaint Management System");
        welcome_text.getStyleClass().add("welcome_text");


        Text description_text = new Text("Welcome to the Apartment Complaint Management System (ACMS), \n" +
                "\tyour essential tool for efficiently handling tenant complaints.\n" +
                "Designed specifically for apartment managers, this application streamlines\n" +
                "the process of logging, tracking, and resolving complaints, ensuring that\n" +
                "\t  \t every issue is addressed in a timely manner.");
        description_text.getStyleClass().add("description_text");




        Text end_text = new Text("Join us in transforming the way you manage apartment complaints.\n" +
                "\tYour first step towards streamlined operations begin here!");
        end_text.getStyleClass().add("end-text");

        Button start_button = new Button("Let's Get Started!");
        start_button.setOnAction(e->{
            MenuPage menuPage = new MenuPage();
            try {
                menuPage.start(stage);
            } catch (IOException ex) {
                System.out.println("Start button is not working!");
                throw new RuntimeException(ex);
            }
        });

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(5), start_button);
        scaleTransition.setFromX(0.5);
        scaleTransition.setFromY(0.5);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setCycleCount(1);
        scaleTransition.play();

        //Image to put in background
        Image background_image_class = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/org/example/java3_final_project/Images/b3.jpg")));
        BackgroundSize backgroundSize = new BackgroundSize(1500, 750, true, true, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background_image_class,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        //sub layout
        VBox title_vbox = new VBox(40,welcome_text,description_text,end_text);
        title_vbox.setAlignment(Pos.CENTER);
        HBox button_hbox = new HBox(start_button);
        button_hbox.setAlignment(Pos.CENTER);
        button_hbox.setPadding(new Insets(50));

        //root pane
        BorderPane welcome_scene_rootPane = new BorderPane();
        welcome_scene_rootPane.setBackground(new Background(backgroundImage));
        welcome_scene_rootPane.getStyleClass().add("welcome_page_root");
        welcome_scene_rootPane.setCenter(title_vbox);
        welcome_scene_rootPane.setBottom(button_hbox);
        Scene welcome_scene = new Scene(welcome_scene_rootPane,1500,750);
        welcome_scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/org/example/java3_final_project/main.css")).toExternalForm());
        stage.setScene(welcome_scene);
    }
}
