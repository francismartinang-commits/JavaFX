package com.example.testfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MinimalistHelloApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                MinimalistHelloApp.class.getResource("minimalist-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 400, 250);

        stage.setTitle("Minimalist Hello App - Nash Paragas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}