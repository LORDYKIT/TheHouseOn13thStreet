module com.example.gameproj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;


    opens com.example.gameproj to javafx.fxml;
    exports com.example.gameproj;
}