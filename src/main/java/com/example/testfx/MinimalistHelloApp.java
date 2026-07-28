package com.example.testfx; // Change this to your actual package name

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MinimalistHelloApp extends Application {

    @Override
    public void start(Stage stage) {
        Label greetingLabel = new Label("Press the button to see the greeting.");

        Button helloButton = new Button("Say Hello");

        helloButton.setOnAction(event ->
                greetingLabel.setText("Hello, Nash Paragas!")
        );

        VBox root = new VBox(15);
        root.getChildren().addAll(greetingLabel, helloButton);

        root.setStyle("""
                -fx-alignment: center;
                -fx-padding: 30;
                """);

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("Minimalist Hello App - Nash Paragas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}