package com.nulp.solyha.courseworkfx.driver;

import com.nulp.solyha.courseworkfx.entities.Vegetable;

import java.sql.*;

import static com.nulp.solyha.courseworkfx.controller.EnterDiapasonController.max;
import static com.nulp.solyha.courseworkfx.controller.EnterDiapasonController.min;
import static com.nulp.solyha.courseworkfx.controller.СhefCookMenuController.chefSaladId;

public class VegetableConnector {

    public void addVegetable(Vegetable vegetable){
        String url = "jdbc:sqlserver://localhost;user=DbUser;password=12345;";
        String insert = "INSERT INTO Vegetables (SaladID, VegetableName, Color, Weight, CalPerHundGram, Proteins, Fats, Carbs) Values (?, ?, ?, ?, ?, ?, ?, ?) UPDATE Salads SET Weight = Weight + ? WHERE SaladID = ?";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);

            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setInt(1, chefSaladId);
            statement.setString(2, vegetable.getName());
            statement.setString(3, vegetable.getColor());
            statement.setDouble(4, vegetable.getWeight());
            statement.setDouble(5, vegetable.getCalCapPerHundGram());
            statement.setDouble(6, vegetable.getProteins());
            statement.setDouble(7, vegetable.getFats());
            statement.setDouble(8, vegetable.getCarbs());
            statement.setDouble(9, vegetable.getWeight());
            statement.setInt(10, chefSaladId);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet viewVegetable(int id) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM Vegetables WHERE SaladID = ? AND CalPerHundGram > ? AND CalPerHundGram < ?";
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;user=DbUser;password=12345;");

            PreparedStatement statement = connection.prepareStatement(select);
            statement.setInt(1, id);
            statement.setDouble(2, min);
            statement.setDouble(3, max);
            resultSet = statement.executeQuery();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return resultSet;
    }

    public void deleteVegetable(int id, double weight) {
        String delete = "UPDATE Salads SET [Weight] = [Weight] - ? WHERE SaladID = ? DELETE FROM Vegetables WHERE VegetableID = ?";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;user=DbUser;password=12345;");

            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setDouble(1, weight);
            statement.setInt(2, chefSaladId);
            statement.setInt(3, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
