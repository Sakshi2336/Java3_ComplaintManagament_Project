module org.example.java3_final_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.java3_final_project to javafx.fxml;
    exports org.example.java3_final_project;
}