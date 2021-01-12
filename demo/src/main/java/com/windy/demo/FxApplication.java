package com.windy.demo;

import com.windy.demo.css.BaseDemo;
import com.windy.demo.css.IndexPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        IndexPane indexPane = new IndexPane();
        Scene scene = new Scene(indexPane, 1280, 1024);
        stage.setScene(scene);
        stage.show();
    }
}
