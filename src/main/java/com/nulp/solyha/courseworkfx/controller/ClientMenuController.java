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

public class ClientMenuController {
    public static int clientSaladId = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ClientMenuExitButton;

    @FXML
    private Button ClientMenuReturnButton;

    @FXML
    private TableView<Salad> ClientSaladTable;

    @FXML
    private TableColumn<Salad, String> SaladID;

    @FXML
    private TableColumn<Salad, String> SaladName;

    @FXML
    private TableColumn<Salad, String> SaladWeight;

    @FXML
    private Button ShowSaladIngrButton;

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

        ClientSaladTable.setItems(list);

        ClientMenuExitButton.setOnAction(event ->{
            Main.CloseScene(ClientMenuExitButton);
        });

        ClientMenuReturnButton.setOnAction(event ->{
            Main.SwitchScene("StartMenu.fxml", ClientMenuReturnButton);
        });

        ShowSaladIngrButton.setOnAction(event ->{
            clientSaladId = ClientSaladTable.getSelectionModel().getSelectedItem().getId();
            Main.SwitchScene("ClientVegetables.fxml", ShowSaladIngrButton);
        });

    }

}

