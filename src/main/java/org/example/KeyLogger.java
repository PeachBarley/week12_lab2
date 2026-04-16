package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyLogger extends Application {

    @Override
    public void start(Stage stage) {

        TextField textField = new TextField();

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefRowCount(5);

        Button clearButton = new Button("Clear Log");
        clearButton.setOnAction(e -> textArea.clear());

        textField.setOnKeyPressed(e -> {
            textArea.appendText(String.format("PRESSED | Code: %s | Shift: %b | Ctrl: %b%n", e.getCode(), e.isShiftDown(), e.isControlDown()));
        });

        textField.setOnKeyReleased(e -> {
            textArea.appendText(String.format("RELEASED | Code: %s%n", e.getCode()));
        });

        textField.setOnKeyTyped(e -> {textArea.appendText(String.format("TYPED | Char: %s%n", e.getCharacter()));
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(textField, textArea, clearButton);

        Scene scene = new Scene(vbox, 420, 320);
        stage.setTitle("Key Logger");
        stage.setScene(scene);
        stage.show();
        textField.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}