package com.windy.demo.css;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class IndexPane extends Pane {
    private final GridPane gridPane = new GridPane();
    private final HBox hBox = new HBox();

    private final String[] keys =
            {
                    "1", "2", "3",
                    "4", "5", "6",
                    "7", "8", "9",
                    "x", "0", "删除"
            };

    private final TextField txtKeyword = new TextField();
    private final Button btnSearch = new Button("查询");

    public IndexPane() {
        //gridPane和hBox设置
        gridPane.layoutXProperty().bind(widthProperty().multiply(0.1));
        gridPane.layoutYProperty().bind(heightProperty().multiply(0.2));


        txtKeyword.setPromptText("请输入身份证");
        txtKeyword.layoutXProperty().bind(widthProperty().multiply(0.12));
        txtKeyword.layoutYProperty().bind(heightProperty().multiply(0.20));
        txtKeyword.prefHeightProperty().bind(heightProperty().multiply(0.11));
        txtKeyword.prefWidthProperty().bind(widthProperty().multiply(0.4));
        btnSearch.layoutXProperty().bind(txtKeyword.layoutXProperty()
                .add(txtKeyword.widthProperty()).add(widthProperty().multiply(0.04)));
        btnSearch.layoutYProperty().bind(txtKeyword.layoutYProperty());
        btnSearch.prefWidthProperty().bind(widthProperty().multiply(0.11));
        btnSearch.prefHeightProperty().bind(heightProperty().multiply(0.11));


        for (int i = 0; i < 12; i++) {
            Button button = new Button(keys[i]);
            button.getStyleClass().add("num-button");
            button.layoutXProperty().bind(txtKeyword.layoutXProperty().add(widthProperty().multiply(((i % 3)) * 0.03)));
            button.layoutYProperty().bind(txtKeyword.layoutYProperty().add(heightProperty().multiply((i / 3 + 1) * 0.02)));
            button.prefWidthProperty().bind(widthProperty().multiply(0.12));
            button.prefHeightProperty().bind(heightProperty().multiply(0.15));
            button.setOnMouseClicked(event -> input(event));
            button.setOnMouseReleased(event -> release(event));
            String style =  numberToEnglish(keys[i]);
                    button.getStyleClass().add(style);
            gridPane.getChildren().add(button);
        }

        hBox.getChildren().addAll(txtKeyword,btnSearch);

        getChildren().addAll(gridPane, hBox);
    }

    private void release(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.getStyleClass().add(numberToEnglish(button.getText()).concat("click"));
    }

    private void input(MouseEvent event) {
        Button keywordsBtn = (Button) event.getSource();
        String preText = txtKeyword.getText();
        String nowKeyWordstext = keywordsBtn.getText();
        String nowText = "";
        int strlen = preText.length();
        if ("删除".equals(nowKeyWordstext)) {
            if (strlen > 0) {
                nowText = preText.substring(0, strlen - 1);
            }
        } else {
            if (preText.length() > 17) {
                nowText = preText;
                throw new RuntimeException("请检查您输入的号码是否正确");
            } else {
                nowText = preText.concat(nowKeyWordstext);
            }
        }
        txtKeyword.setText(nowText);
    }


    private String numberToEnglish(String number) {
        switch (number){
            case "0" :
                return "zero";
            case "1" :
                return "one";
            case "2" :
                return "two";
            case "3" :
                return "three";
            case "4" :
                return "four";
            case "5" :
                return "five";
            case "6" :
                return "six";
            case "7" :
                return "seven";
            case "8" :
                return "eight";
            case "9" :
                return "nine";
            case "x" :
                return "x";
            case "删除" :
                return "delete";
        }
        return null;
    }
}
