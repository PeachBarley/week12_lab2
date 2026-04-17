package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private final Stage stage;
    private final Scene scene;

    public LoginView(Stage stage) {
        this.stage = stage;

        Label titleLabel = new Label("Login");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label messageLabel = new Label();

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        Button loginButton = new Button("Log In");
        Button registerButton = new Button("Register");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Please fill in all fields");
                return;
            }

            if (UserFileHandler.validateLogin(username, password)) {
                WelcomeView welcomeView = new WelcomeView(stage, username);
                stage.setScene(welcomeView.getScene());
            } else {
                messageLabel.setText("Incorrect username or password");
            }
        });

        registerButton.setOnAction(e -> {
            RegisterView registerView = new RegisterView(stage);
            stage.setScene(registerView.getScene());
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, registerButton, messageLabel);
        this.scene = new Scene(vbox, 1000, 500);
    }

    public Scene getScene() {
        return scene;
    }
}