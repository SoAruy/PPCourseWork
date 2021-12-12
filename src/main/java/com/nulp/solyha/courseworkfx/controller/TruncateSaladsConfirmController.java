package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import com.nulp.solyha.courseworkfx.driver.SaladConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TruncateSaladsConfirmController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button TruncateNoButton;

    @FXML
    private Button TruncateYesButton;

    @FXML
    void initialize() {
        SaladConnector db = new SaladConnector();

        TruncateYesButton.setOnAction(event ->{
            db.truncateSalads();
            Main.SwitchScene("ChefCookMenu.fxml", TruncateYesButton);
        });

        TruncateNoButton.setOnAction(event ->{
            Main.SwitchScene("ChefCookMenu.fxml", TruncateNoButton);
        });
    }

}
