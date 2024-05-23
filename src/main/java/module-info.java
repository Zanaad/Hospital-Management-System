module com.example.projektiknk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens controller to javafx.fxml;
    exports app;
    opens model.dto.StaffDto to javafx.base;
    opens model.dto.RecDto to javafx.base;
    opens model.dto to javafx.base;
    opens model to javafx.base;
}