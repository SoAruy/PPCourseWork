package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import com.nulp.solyha.courseworkfx.driver.VegetableConnector;
import com.nulp.solyha.courseworkfx.entities.Vegetable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateVegetableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CreateVegCalCapTextField;

    @FXML
    private TextField CreateVegCarbsTextField;

    @FXML
    private ComboBox<String> CreateVegColorComboBox;

    @FXML
    private TextField CreateVegWeightTextField;

    @FXML
    private TextField CreateVegFatsTextField;

    @FXML
    private TextField CreateVegNameTextField;

    @FXML
    private TextField CreateVegProteinsTextField;

    @FXML
    private Button CreateVegetableCancelButton;

    @FXML
    private Button CreateVegetableSubmitButton;

    @FXML
    void initialize() {
        CreateVegColorComboBox.getItems().addAll("Red",
                "Orange",
                "Yellow",
                "Green",
                "Blue",
                "Indigo",
                "Violet");

        CreateVegetableCancelButton.setOnAction(event ->{
            Main.SwitchScene("ChefCookVegetables.fxml", CreateVegetableCancelButton);
        });

        CreateVegetableSubmitButton.setOnAction(event ->{
            String name = CreateVegNameTextField.getText();
            String color = CreateVegColorComboBox.getSelectionModel().getSelectedItem().toString();
            Double weight = Double.valueOf(CreateVegWeightTextField.getText());
            Double calCap = Double.valueOf(CreateVegCalCapTextField.getText());
            Double proteins = Double.valueOf(CreateVegProteinsTextField.getText());
            Double fats = Double.valueOf(CreateVegFatsTextField.getText());
            Double carbs = Double.valueOf(CreateVegCarbsTextField.getText());

            Vegetable vegetable = new Vegetable(name, color, weight, calCap, proteins, fats, carbs);
            VegetableConnector vegetableConnector = new VegetableConnector();
            vegetableConnector.addVegetable(vegetable);
            Main.SwitchScene("ChefCookVegetables.fxml", CreateVegetableSubmitButton);
        });
    }

}
