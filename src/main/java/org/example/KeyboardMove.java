package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class KeyboardMove extends Application {

    @Override
    public void start(Stage stage) {

        Pane pane = new Pane();
        pane.setPrefSize(500, 400);

        Rectangle rectangle = new Rectangle(220, 180, 60, 40);
        rectangle.setFill(Color.BLUE);

        TextField textField = new TextField("X: 220 Y: 180");
        textField.setEditable(false);

        pane.getChildren().add(rectangle);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(textField);

        Scene scene = new Scene(borderPane, 500, 430);

        scene.setOnKeyPressed(e -> {
            double x = rectangle.getX();
            double y = rectangle.getY();

            if (e.getCode() == KeyCode.UP) y -= 1;
            if (e.getCode() == KeyCode.DOWN) y += 1;
            if (e.getCode() == KeyCode.LEFT) x -= 1;
            if (e.getCode() == KeyCode.RIGHT) x += 1;
            if (x < 0) x = 0;
            if (x > 440) x = 440;
            if (y < 0) y = 0;
            if (y > 360) y = 360;

            rectangle.setX(x);
            rectangle.setY(y);
            textField.setText("X: " + (int)x + " Y: " + (int)y);
        });

        stage.setScene(scene);
        stage.setTitle("Keyboard Move");
        stage.show();
        scene.getRoot().requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
