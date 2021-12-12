package com.nulp.solyha.courseworkfx.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.nulp.solyha.courseworkfx.Main;
import com.nulp.solyha.courseworkfx.driver.SaladConnector;
import com.nulp.solyha.courseworkfx.entities.Salad;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class СhefCookMenuController {
    public static int chefSaladId = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ChefCookMenuExitButton;

    @FXML
    private Button ChefCookMenuReturnButton;

    @FXML
    private Button CreateSaladButton;

    @FXML
    private Button DeleteSaladButton;

    @FXML
    private Button EditSaladButton;

    @FXML
    private Button TruncateTableButton;

    @FXML
    private TableView<Salad> ChefCookSaladTable;

    @FXML
    private TableColumn<Salad, String> SaladID;

    @FXML
    private TableColumn<Salad, String> SaladName;

    @FXML
    private TableColumn<Salad, String> SaladWeight;

    ObservableList<Salad> list = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        SaladConnector db = new SaladConnector();
        ResultSet result = db.viewSalad();

        while (true) {
            try {
                if (!result.next())
                    break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                list.add(new Salad(result.getInt(1), result.getString(2), result.getDouble(3)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        SaladID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdString()));
        SaladName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        SaladWeight.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWeightString()));

        ChefCookSaladTable.setItems(list);

        TruncateTableButton.setOnAction(event ->{
            Main.SwitchScene("TruncateConfirm.fxml", TruncateTableButton);
        });

        ChefCookMenuExitButton.setOnAction(event ->{
            Main.CloseScene(ChefCookMenuExitButton);
        });

        ChefCookMenuReturnButton.setOnAction(event ->{
            Main.SwitchScene("StartMenu.fxml", ChefCookMenuReturnButton);
        });

        CreateSaladButton.setOnAction(event ->{
            Main.SwitchScene("CreateSalad.fxml", CreateSaladButton);
        });

        DeleteSaladButton.setOnAction(event ->{
            chefSaladId = ChefCookSaladTable.getSelectionModel().getSelectedItem().getId();
            db.deleteSalad(chefSaladId);
            Main.SwitchScene("ChefCookMenu.fxml", DeleteSaladButton);
        });

        EditSaladButton.setOnAction(event ->{
            chefSaladId = ChefCookSaladTable.getSelectionModel().getSelectedItem().getId();
            Main.SwitchScene("ChefCookVegetables.fxml", EditSaladButton);
        });
    }

}

