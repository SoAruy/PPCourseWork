package com.nulp.solyha.courseworkfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("StartMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image("C:\\Users\\user\\IdeaProjects\\CourseWorkFX\\src\\main\\resources\\assets\\mainIcon.png"));
        stage.setTitle("Course Work");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void SwitchScene(String str, Button button){
        button.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(str));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setTitle("Course Work");
        stage.setScene(new Scene(fxmlLoader.getRoot()));
        stage.getIcons().add(new Image("C:\\Users\\user\\IdeaProjects\\CourseWorkFX\\src\\main\\resources\\assets\\mainIcon.png"));
        stage.setResizable(false);
        stage.show();
    };

    public static void CloseScene(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

}