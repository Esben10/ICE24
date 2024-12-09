package org.ICE24;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoginService {

    public static User createUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Create a New User ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (userExists(username)) {
            System.out.println("Username already exists");
            return null;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        if (saveCredentials(username, password)) {
            System.out.println("User created successfully!");
        } else {
            System.out.println("Failed to create user. Please try again.");
            return null;
        }
        return new User(username, password);
    }


    private static boolean saveCredentials(String username, String password) {
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(username + ":" + password + System.lineSeparator());
            return true;
        } catch (IOException e) {
            System.err.println("Error saving credentials: " + e.getMessage());
            return false;
        }
    }

    public static boolean userExists(String username) {
        try (Scanner reader = new Scanner(new File("users.txt"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.startsWith(username)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            System.err.println("Error looking up user: " + e.getMessage());
            return false;
        }
    }

}


