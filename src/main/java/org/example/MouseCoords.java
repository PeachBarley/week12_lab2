package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MouseCoords extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Move the mouse over the pane");

        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(400, 300);
        stackPane.setStyle("-fx-background-color: lightblue;");

        stackPane.setOnMouseMoved(e -> {
            label.setText(String.format("X: %.1f Y: %.1f", e.getX(), e.getY()));
        });

        stackPane.setOnMouseClicked(e -> {
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            stackPane.setStyle(String.format("-fx-background-color: rgb(%d,%d,%d);", r, g, b));
        });

        stackPane.setOnMouseExited(e -> {
            label.setText("Move the mouse over the pane");
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(stackPane);
        borderPane.setBottom(label);
        BorderPane.setAlignment(label, Pos.CENTER);

        Scene scene = new Scene(borderPane, 400, 330);
        stage.setTitle("Mouse Coordinates");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}