package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import com.nulp.solyha.courseworkfx.driver.SaladConnector;
import com.nulp.solyha.courseworkfx.entities.Salad;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateSaladController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CreateSaladCancelButton;

    @FXML
    private Button CreateSaladSubmitButton;

    @FXML
    private TextField CreateSaladTextField;

    @FXML
    void initialize() {
        CreateSaladCancelButton.setOnAction(event ->{
            Main.SwitchScene("ChefCookMenu.fxml", CreateSaladCancelButton);
        });

        CreateSaladSubmitButton.setOnAction(event ->{
            String name = CreateSaladTextField.getText();

            Salad salad = new Salad(name);
            SaladConnector saladConnector = new SaladConnector();
            saladConnector.addSalad(salad);
            Main.SwitchScene("ChefCookMenu.fxml", CreateSaladSubmitButton);
        });
    }

}
