module com.nulp.solyha.courseworkfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nulp.solyha.courseworkfx to javafx.fxml;
    exports com.nulp.solyha.courseworkfx;
    exports com.nulp.solyha.courseworkfx.controller;
    opens com.nulp.solyha.courseworkfx.controller to javafx.fxml;
}