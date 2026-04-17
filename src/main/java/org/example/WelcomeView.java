package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeView {
    private final Stage stage;
    private final Scene scene;

    public WelcomeView(Stage stage, String username) {
        this.stage = stage;

        Label applicationLabel = new Label("My Application");
        applicationLabel.setStyle(""" 
                -fx-font-size: 18px;
                -fx-text-fill: #5c6f8a; 
                """);

        StackPane stackPane = new StackPane(applicationLabel);
        stackPane.setPadding(new Insets(10));
        stackPane.setStyle("-fx-background-color: #d9dee7;");

        Label welcomeLabel = new Label("Welcome, " + username + "!");
        welcomeLabel.setStyle("""
                -fx-font-size: 28px;
                -fx-font-weight: bold;
                -fx-text-fill: #1f3b67;
                """);

        Button button = new Button("Log Out");
        button.setPrefWidth(280);
        button.setPrefHeight(45);
        button.setStyle("""
                -fx-background-color: #1f3b67;
                -fx-text-fill: white;
                -fx-font-size: 20px;
                """);

        button.setOnAction(e -> {
            LoginView loginView = new LoginView(stage);
            stage.setScene(loginView.getScene());
        });

        VBox vbox = new VBox(30, welcomeLabel, button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setCenter(vbox);
        this.scene = new Scene(borderPane, 1000, 500);
    }

    public Scene getScene() {
        return scene;
    }
}