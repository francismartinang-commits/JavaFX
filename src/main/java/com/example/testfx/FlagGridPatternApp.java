package com.example.testfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FlagGridPatternApp extends Application {

    private static final int FLAG_WIDTH = 100;
    private static final int FLAG_HEIGHT = 50;

    @Override
    public void start(Stage primaryStage) {
        // Launching all 5 patterns simultaneously
        showGridPatternStage("JavaFX Flag Grid", primaryStage);
        showDiamondPatternStage("BorderPane Display - Diamond", new Stage());
        showCrossPatternStage("BorderPane Display - Cross", new Stage());
        showOPatternStage("StackPane O-Pattern", new Stage());
        showXPatternStage("AnchorPane X-Pattern", new Stage());
    }

    private Canvas createFlag() {
        PhilippineFlagApp flagGenerator = new PhilippineFlagApp(FLAG_WIDTH, FLAG_HEIGHT);
        return flagGenerator.drawFlag(FLAG_WIDTH, FLAG_HEIGHT, 0, 0);
    }

    // =========================================================================
    // 1. GridPane (5x5 Pattern)
    // =========================================================================
    private void showGridPatternStage(String title, Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(20));

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                gridPane.add(createFlag(), col, row);
            }
        }

        Scene scene = new Scene(gridPane, 700, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

