package com.windy.demo.css;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class BaseDemo extends Pane {

    private final Button button = new Button("打地鼠");

    public BaseDemo() {
        button.prefWidth(200);
        button.prefHeight(100);
        //button.setStyle("-fx-background-image: url('/img/0.png')");
        button.getStyleClass().add("button0change");
        button.setOnAction(event -> changeImage());
        button.setOnMouseReleased(event -> {
        });
        getChildren().addAll(button);
    }






    private void changeImage() {
        button.setStyle("-fx-background-image: url('/img/0-1.png')");
    }
}
