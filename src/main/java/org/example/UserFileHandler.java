package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileHandler {
    private static final String fileName = "users.txt";
    private static final String separator = "\\|";

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return users;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(separator);
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    String email = parts[2].trim();
                    users.add(new User(username, password, email));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

            return users;
    }
        public static boolean usernameExists(String username) {
        for (User user : getAllUsers()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean emailExists(String email) {
        for (User user : getAllUsers()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateLogin(String username, String password) {
        for (User user : getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean registerUser(String username, String password, String email) {
        if (usernameExists(username) || emailExists(email)) {
            return false;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.write(username + " | " + password + " | " + email);
            bufferedWriter.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}