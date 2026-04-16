package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleCalc extends Application {

    @Override
    public void start(Stage stage) {

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Label label1 = new Label("Number 1:");
        Label label2 = new Label("Number 2:");
        Label resultLabel = new Label("Result:");

        Button calcButton = new Button("Calculate");
        Button clearButton = new Button("Clear");

        calcButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double sum = num1 + num2;
                resultField.setText(String.format("Sum: %.2f", sum));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input!");
            }
        });

        clearButton.setOnAction(e -> {
            textField1.clear();
            textField2.clear();
            resultField.clear();
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(label1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(resultLabel, 0, 2);
        gridPane.add(resultField, 1, 2);
        gridPane.add(calcButton, 0, 3);
        gridPane.add(clearButton, 1, 3);

        Scene scene = new Scene(gridPane, 300, 200);
        stage.setTitle("Simple Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}