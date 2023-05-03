module com.cophea {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cophea to javafx.fxml;
    exports com.cophea;
}
