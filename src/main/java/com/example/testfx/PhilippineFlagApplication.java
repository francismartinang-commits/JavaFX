package com.example.testfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PhilippineFlagApplication extends Application {

    @Override
    public void start(Stage stage) {
        PhilippineFlagApp philippineFlag =
                new PhilippineFlagApp(600, 300);

        Canvas flagCanvas =
                philippineFlag.drawFlag(600, 300, 0, 0);

        VBox root = new VBox(flagCanvas);

        Scene scene = new Scene(root, 600, 300);

        stage.setTitle("Philippine Flag by Group 10");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}