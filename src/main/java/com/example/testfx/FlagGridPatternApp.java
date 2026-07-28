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

    // =========================================================================
    // 4. O-Pattern (BorderPane -> Center StackPane)
    // =========================================================================
    private void showOPatternStage(String title, Stage stage) {
        StackPane stackPane = new StackPane();
        double gapX = 15;
        double gapY = 15;
        stackPane.setMaxSize(FLAG_WIDTH * 3 + gapX * 2, FLAG_HEIGHT * 3 + gapY * 2);

        Canvas tl = createFlag(); StackPane.setAlignment(tl, Pos.TOP_LEFT);
        Canvas tc = createFlag(); StackPane.setAlignment(tc, Pos.TOP_CENTER);
        Canvas tr = createFlag(); StackPane.setAlignment(tr, Pos.TOP_RIGHT);

        Canvas cl = createFlag(); StackPane.setAlignment(cl, Pos.CENTER_LEFT);
        Canvas cr = createFlag(); StackPane.setAlignment(cr, Pos.CENTER_RIGHT);

        Canvas bl = createFlag(); StackPane.setAlignment(bl, Pos.BOTTOM_LEFT);
        Canvas bc = createFlag(); StackPane.setAlignment(bc, Pos.BOTTOM_CENTER);
        Canvas br = createFlag(); StackPane.setAlignment(br, Pos.BOTTOM_RIGHT);

        stackPane.getChildren().addAll(tl, tc, tr, cl, cr, bl, bc, br);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(stackPane);

        Scene scene = new Scene(borderPane, 700, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    // =========================================================================
    // 5. X-Pattern (AnchorPane)
    // =========================================================================
    private void showXPatternStage(String title, Stage stage) {
        AnchorPane anchorPane = new AnchorPane();


        double gapX = 0;
        double gapY = 0;

        double startX = 100;
        double startY = 125;

        // 5x5 Grid representation forming the 'X' shape
        int[][] xCoordinates = {
                {0, 4},
                {1, 3},
                {2},
                {1, 3},
                {0, 4}
        };

        for (int row = 0; row < xCoordinates.length; row++) {
            for (int col : xCoordinates[row]) {
                Canvas flag = createFlag();
                AnchorPane.setTopAnchor(flag, startY + row * (FLAG_HEIGHT + gapY));
                AnchorPane.setLeftAnchor(flag, startX + col * (FLAG_WIDTH + gapX));
                anchorPane.getChildren().add(flag);
            }
        }

        Scene scene = new Scene(anchorPane, 700, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

