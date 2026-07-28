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

    // =========================================================================
    // 2. Diamond Pattern (StackPane -> BorderPane -> HBox/VBox)
    // =========================================================================
    private void showDiamondPatternStage(String title, Stage stage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().add(createFlag());
        BorderPane.setMargin(topBox, new Insets(0, 0, 20, 0));

        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(createFlag());
        BorderPane.setMargin(bottomBox, new Insets(20, 0, 0, 0));

        VBox leftBox = new VBox();
        leftBox.setAlignment(Pos.CENTER);
        leftBox.getChildren().add(createFlag());
        BorderPane.setMargin(leftBox, new Insets(0, 40, 0, 0));

        VBox rightBox = new VBox();
        rightBox.setAlignment(Pos.CENTER);
        rightBox.getChildren().add(createFlag());
        BorderPane.setMargin(rightBox, new Insets(0, 0, 0, 40));

        HBox centerRow1 = new HBox(40);
        centerRow1.setAlignment(Pos.CENTER);
        centerRow1.getChildren().addAll(createFlag(), createFlag());

        HBox centerRow2 = new HBox(40);
        centerRow2.setAlignment(Pos.CENTER);
        centerRow2.getChildren().addAll(createFlag(), createFlag());

        VBox centerBox = new VBox(20);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(centerRow1, centerRow2);

        borderPane.setTop(topBox);
        borderPane.setBottom(bottomBox);
        borderPane.setLeft(leftBox);
        borderPane.setRight(rightBox);
        borderPane.setCenter(centerBox);

        StackPane root = new StackPane(borderPane);

        Scene scene = new Scene(root, 700, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    // =========================================================================
    // 3. Cross Pattern (StackPane -> BorderPane -> HBox/VBox)
    // =========================================================================
    private void showCrossPatternStage(String title, Stage stage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        HBox topBox = new HBox(20);
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(createFlag(), createFlag());
        BorderPane.setMargin(topBox, new Insets(0, 0, 15, 0));

        HBox bottomBox = new HBox(20);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().addAll(createFlag(), createFlag());
        BorderPane.setMargin(bottomBox, new Insets(15, 0, 0, 0));

        VBox leftBox = new VBox(15);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.getChildren().addAll(createFlag(), createFlag());
        BorderPane.setMargin(leftBox, new Insets(0, 20, 0, 0));

        VBox rightBox = new VBox(15);
        rightBox.setAlignment(Pos.CENTER);
        rightBox.getChildren().addAll(createFlag(), createFlag());
        BorderPane.setMargin(rightBox, new Insets(0, 0, 0, 20));

        HBox centerRow1 = new HBox(20);
        centerRow1.setAlignment(Pos.CENTER);
        centerRow1.getChildren().addAll(createFlag(), createFlag());

        HBox centerRow2 = new HBox(20);
        centerRow2.setAlignment(Pos.CENTER);
        centerRow2.getChildren().addAll(createFlag(), createFlag());

        VBox centerBox = new VBox(15);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(centerRow1, centerRow2);

        borderPane.setTop(topBox);
        borderPane.setBottom(bottomBox);
        borderPane.setLeft(leftBox);
        borderPane.setRight(rightBox);
        borderPane.setCenter(centerBox);

        StackPane root = new StackPane(borderPane);

        Scene scene = new Scene(root, 700, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

