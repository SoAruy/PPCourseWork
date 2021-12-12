package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import com.nulp.solyha.courseworkfx.driver.VegetableConnector;
import com.nulp.solyha.courseworkfx.entities.Vegetable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import static com.nulp.solyha.courseworkfx.controller.EnterDiapasonController.max;
import static com.nulp.solyha.courseworkfx.controller.EnterDiapasonController.min;


import static com.nulp.solyha.courseworkfx.controller.ClientMenuController.clientSaladId;

public class ClientVegetableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ResultTextField;

    @FXML
    private Button CalculateSalCalButton;

    @FXML
    private TableView<Vegetable> ClientVegetableTable;

    @FXML
    private Button ClientVegMenuExitButton;

    @FXML
    private Button ClientVegMenuReturnButton;

    @FXML
    private Button FindByDiapasonButton;

    @FXML
    private TableColumn<Vegetable, String> VegCalorificCapacity;

    @FXML
    private TableColumn<Vegetable, String> VegSaladID;

    @FXML
    private TableColumn<Vegetable, String> VegetableC;

    @FXML
    private TableColumn<Vegetable, String> VegetableColor;

    @FXML
    private TableColumn<Vegetable, String> VegetableF;

    @FXML
    private TableColumn<Vegetable, String> VegetableID;

    @FXML
    private TableColumn<Vegetable, String> VegetableName;

    @FXML
    private TableColumn<Vegetable, String> VegetableP;

    @FXML
    private TableColumn<Vegetable, String> VegetableWeight;

    ObservableList<Vegetable> list = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        VegetableConnector db = new VegetableConnector();
        ResultSet result = db.viewVegetable(clientSaladId);

        while (true) {
            try {
                if (!result.next())
                    break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                list.add(new Vegetable(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getDouble(5), result.getDouble(6), result.getDouble(7), result.getDouble(8), result.getDouble(9)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        VegetableID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStringId()));
        VegSaladID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStringSaladId()));
        VegetableName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        VegetableColor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getColor()));
        VegetableWeight.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStringWeight()));
        VegCalorificCapacity.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStringCalCap()));
        VegetableP.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStringProteins()));
        VegetableF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStringFats()));
        VegetableC.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStringCarbs()));

        ClientVegetableTable.setItems(list);

        CalculateSalCalButton.setOnAction(event ->{
            Double sum = 0.0;
            for (int i = 0; i < list.size(); i++){
                sum += list.get(i).getWeight() * 0.01 * list.get(i).getCalCapPerHundGram();
            }

            ResultTextField.setText(sum.toString());
        });

        ClientVegMenuReturnButton.setOnAction(event ->{
            min = 0.0;
            max = 1000000000.0;
            Main.SwitchScene("ClientMenu.fxml", ClientVegMenuReturnButton);
        });

        ClientVegMenuExitButton.setOnAction(event ->{
            Main.CloseScene(ClientVegMenuExitButton);
        });

        FindByDiapasonButton.setOnAction(event->{
            Main.SwitchScene("EnterDiapason.fxml", FindByDiapasonButton);
        });
    }
}
