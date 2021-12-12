package com.nulp.solyha.courseworkfx.driver;

import com.nulp.solyha.courseworkfx.entities.Salad;
import java.sql.*;

public class SaladConnector {

    public void addSalad(Salad salad){
        String url = "jdbc:sqlserver://localhost;user=DbUser;password=12345;";
        String insert = "INSERT INTO Salads (SaladName, Weight) Values (?, ?)";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);

            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, salad.getName());
            statement.setDouble(2, salad.getWeight());
            statement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet viewSalad() {
        ResultSet resultSet = null;

        String select = "SELECT * FROM Salads";
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;user=DbUser;password=12345;");

            PreparedStatement statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return resultSet;
    }

    public void deleteSalad(int id){
        String delete = "DELETE FROM Vegetables WHERE SaladID = ? DELETE FROM Salads WHERE SaladID = ?";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;user=DbUser;password=12345;");

            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void truncateSalads(){
        String truncate = "TRUNCATE TABLE dbo.Vegetables DELETE FROM Salads DBCC CHECKIDENT ('ChefCook.dbo.Salads', RESEED, 0)";

        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;user=DbUser;password=12345;");

            Statement statement = connection.createStatement();

            statement.executeUpdate(truncate);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
