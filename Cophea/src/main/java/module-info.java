module com.cophea {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.cophea to javafx.fxml;
    exports com.cophea;
}
