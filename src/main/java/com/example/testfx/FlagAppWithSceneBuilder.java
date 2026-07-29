package com.example.testfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlagAppWithSceneBuilder extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                FlagAppWithSceneBuilder.class.getResource("flag.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 400, 200);

        stage.setTitle("Philippine Flag - Group 10");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}