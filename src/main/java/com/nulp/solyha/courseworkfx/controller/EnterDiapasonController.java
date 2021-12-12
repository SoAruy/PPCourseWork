package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EnterDiapasonController {
    public static double min = 0.0;
    public static double max = 1000000000.0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CancelButton;

    @FXML
    private TextField MaximumTextField;

    @FXML
    private TextField MinimumTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    void initialize() {
        SubmitButton.setOnAction(event ->{
            min = Double.valueOf(MinimumTextField.getText());
            max = Double.valueOf(MaximumTextField.getText());
            Main.SwitchScene("ClientVegetables.fxml", SubmitButton);
        });

        CancelButton.setOnAction(event ->{
            Main.SwitchScene("ClientVegetables.fxml", SubmitButton);
        });
    }

}
