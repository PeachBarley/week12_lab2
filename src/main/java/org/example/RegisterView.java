package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterView {
    private final Stage stage;
    private Scene scene;

    public RegisterView(Stage stage) {
        this.stage = stage;

        Label titleLabel = new Label("Register");

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Label confirmPasswordLabel = new Label("Confirm Password:");
        PasswordField confirmPasswordField = new PasswordField();

        Label messageLabel = new Label();

        Button registerButton = new Button("Register");
        Button backButton = new Button("Back to Login");

        registerButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            String confirmPassword = confirmPasswordField.getText().trim();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                messageLabel.setText("Please fill in all fields");
                return;
            }

            if (!password.equals(confirmPassword)) {
                messageLabel.setText("Passwords do not match");
                return;
            }

            if (UserFileHandler.usernameExists(username)) {
                messageLabel.setText("Username already exists");
                return;
            }

            if (UserFileHandler.emailExists(email)) {
                messageLabel.setText("Email already exists");
                return;
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Registration successful\nYou can log in");
            alert.showAndWait();
            LoginView loginView = new LoginView(stage);
            stage.setScene(loginView.getScene());
        });

        backButton.setOnAction(b -> {
            LoginView loginView = new LoginView(stage);
            stage.setScene(loginView.getScene());
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, usernameLabel, usernameField, emailLabel, emailField, passwordLabel, passwordField, confirmPasswordLabel, confirmPasswordField, registerButton, backButton, messageLabel);
        this.scene = new Scene(vbox, 1000, 500);
    }

    public Scene getScene() {
        return scene;
    }
}