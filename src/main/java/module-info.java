module com.example.doctor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.doctor to javafx.fxml;
    opens model_repository to javafx.base;
    exports com.example.doctor;
    exports app;
    opens controller to javafx.fxml;
}