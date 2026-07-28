module com.example.testfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.testfx to javafx.fxml;
    exports com.example.testfx;
}