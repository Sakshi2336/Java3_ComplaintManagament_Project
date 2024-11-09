module org.example.java3_final_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires com.dlsc.formsfx;

    opens org.example.java3_final_project to javafx.fxml;
    exports org.example.java3_final_project;
    exports org.example.java3_final_project.database;
    opens org.example.java3_final_project.database to javafx.fxml;
    exports org.example.java3_final_project.MenuPage;
    opens org.example.java3_final_project.MenuPage to javafx.fxml;
}