package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ChefCookMenuButton;

    @FXML
    private Button ClientMenuButton;

    @FXML
    private Button StartMenuExitButton;

    @FXML
    void initialize() {
        StartMenuExitButton.setOnAction(event -> {
            Main.CloseScene(StartMenuExitButton);
        });

        ChefCookMenuButton.setOnAction(event ->{
            Main.SwitchScene("ChefCookMenu.fxml", ChefCookMenuButton);
        });

        ClientMenuButton.setOnAction(event ->{
            Main.SwitchScene("ClientMenu.fxml", ClientMenuButton);
        });
    }
}