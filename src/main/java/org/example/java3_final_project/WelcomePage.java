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


/**
 *  welcome_scene -> welcome page which will show basic information for
 *  application and have button that will navigate to the main menu page.
 *  This welcome page has:
 *  - text objects -> for welcome , description and end text
 *  - start button -> to navigate to the main menu page
 *  - scale transition for start button
 *  - Background image
 *  - title_vBox -> to pull all 3 text objects
 *  - button_hBox -> to put start button
 *  - welcome_scene_rootPane -> Borderpane as main root pane
 */

public class WelcomePage extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        //Welcome text for application at the top and css class for this text is - welcome_text
        Text welcome_text = new Text("Welcome to the Apartment Complaint Management System");
        welcome_text.getStyleClass().add("welcome_text");


        //Description text which will provide some basic information about application and css class for this text is = description_text
        Text description_text = new Text("Welcome to the Apartment Complaint Management System (ACMS), \n" +
                "\tyour essential tool for efficiently handling tenant complaints.\n" +
                "Designed specifically for apartment managers, this application streamlines\n" +
                "the process of logging, tracking, and resolving complaints, ensuring that\n" +
                "\t  \t every issue is addressed in a timely manner.");
        description_text.getStyleClass().add("description_text");


        //End text and css class for this text is - ent_text
        Text end_text = new Text("Join us in transforming the way you manage apartment complaints.\n" +
                "\tYour first step towards streamlined operations begin here!");
        end_text.getStyleClass().add("end_text");


        //Start button that will go to the main MenuPage
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


        //Scale transition for start button
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(5), start_button);
        scaleTransition.setFromX(0.5);  //50% half from it is original width
        scaleTransition.setFromY(0.5); //50% half from it is original height
        scaleTransition.setToX(1); //to full 100% size
        scaleTransition.setToY(1); //to full 100% size
        scaleTransition.setCycleCount(1);
        scaleTransition.play();

        //Image to put in background
        Image background_image_class = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/org/example/java3_final_project/Images/b3.jpg")));
        // Define the size of the area that a BackgroundImage should fill relative
        // to the Region it is styling. There are several properties who's values
        // take precedence over the others. In particular there are 4 key properties,
        // width, height, contain, and cover.
        BackgroundSize backgroundSize = new BackgroundSize(1500, 750, true, true, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background_image_class,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        //Sub layout:
        // -VBox that has 3 text objects
        // -HBox that has start button
        VBox title_vbox = new VBox(40,welcome_text,description_text,end_text);
        title_vbox.setAlignment(Pos.CENTER);
        HBox button_hbox = new HBox(start_button);
        button_hbox.setAlignment(Pos.CENTER);
        button_hbox.setPadding(new Insets(50));

        //Root pane - BorderPane
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
