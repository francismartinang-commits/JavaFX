package com.example.testfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MinimalistHelloController {

    @FXML
    private Label greetingLabel;

    @FXML
    protected void onHelloButtonClick() {
        greetingLabel.setText("Hello LBYCPOB OOP, I am Nash Paragas!");
    }
}