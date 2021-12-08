package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class СhefCookMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ChefCookMenuExitButton;

    @FXML
    private Button ChefCookMenuReturnButton;

    @FXML
    private Button SaladMenuButton;

    @FXML
    private Button VegetablesMenuButton;

    @FXML
    void initialize() {
        ChefCookMenuExitButton.setOnAction(event ->{
            Main.CloseScene(ChefCookMenuExitButton);
        });

        ChefCookMenuReturnButton.setOnAction(event ->{
            Main.SwitchScene("StartMenu.fxml", ChefCookMenuReturnButton);
        });
    }

}

