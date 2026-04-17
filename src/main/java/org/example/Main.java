package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("User Login and Registration System");
        LoginView loginView = new LoginView(stage);
        stage.setScene(loginView.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}