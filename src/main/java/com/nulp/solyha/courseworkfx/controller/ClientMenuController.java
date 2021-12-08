package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ClientMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ClientMenuExitButton;

    @FXML
    private Button ClientMenuReturnButton;

    @FXML
    private Button SaladMenuButton;

    @FXML
    private Button VegetablesMenuButton;

    @FXML
    void initialize() {
        ClientMenuExitButton.setOnAction(event ->{
            Main.CloseScene(ClientMenuExitButton);
        });

        ClientMenuReturnButton.setOnAction(event ->{
            Main.SwitchScene("StartMenu.fxml", ClientMenuReturnButton);
        });
    }

}
