package org.example.java3_final_project;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addComplaintForm extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        /**
         * @JavaDoc Creating Add Complaint Form
         * It includes:
         * Tenant Info
         * Complaint Details
         * Buttons
         */

        GridPane root = new GridPane();

        Text tenantInfoHeading = new Text("Tenant Info");

        Label tenantName = new Label("Tenant Name:");
        TextField tenantNameInput = new TextField();

        Label flatNumber = new Label("Flat Number:");
        TextField flatNumberInput = new TextField();

        Label contactInfo = new Label("Contact Info:");
        TextField contactInfoInput = new TextField();

        



    }
}
