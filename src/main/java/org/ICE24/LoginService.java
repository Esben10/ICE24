package org.ICE24; // Defines the package for the class.

import java.io.File; // Imports the File class for handling file operations.
import java.io.FileNotFoundException; // Imports exception class for handling missing files.
import java.io.FileWriter; // Imports the FileWriter class for writing to files.
import java.io.IOException; // Imports the IOException class for handling I/O errors.
import java.util.Scanner; // Imports the Scanner class for reading input and files.

public class LoginService { // Defines the LoginService class for managing user operations.

    public static User createUser() { // Method to create a new user.
        Scanner scanner = new Scanner(System.in); // Creates a scanner to read input from the console.

        System.out.println("=== Create a New User ==="); // Prints a header for user creation.
        System.out.print("Enter username: "); // Prompts the user to enter a username.
        String username = scanner.nextLine(); // Reads the entered username.

        if (userExists(username)) { // Checks if the username already exists in the system.
            System.out.println("Username already exists"); // Notifies the user if the username is taken.
            return null; // Returns null to indicate failure to create the user.
        }

        System.out.print("Enter password: "); // Prompts the user to enter a password.
        String password = scanner.nextLine(); // Reads the entered password.

        if (saveCredentials(username, password)) { // Attempts to save the user's credentials.
            System.out.println("User created successfully!"); // Confirms successful user creation.
        } else { // Handles failure to save credentials.
            System.out.println("Failed to create user. Please try again."); // Informs the user about the failure.
            return null; // Returns null to indicate failure.
        }
        return new User(username, password); // Returns a new User object with the provided credentials.
    }

    private static boolean saveCredentials(String username, String password) { // Saves user credentials to a file.
        try (FileWriter writer = new FileWriter("users.txt", true)) { // Opens "users.txt" in append mode.
            writer.write(username + ":" + password + System.lineSeparator()); // Writes credentials in "username:password" format.
            return true; // Returns true to indicate success.
        } catch (IOException e) { // Handles exceptions during file writing.
            System.err.println("Error saving credentials: " + e.getMessage()); // Prints the error message.
            return false; // Returns false to indicate failure.
        }
    }

    public static boolean userExists(String username) { // Checks if a username already exists in the system.
        try (Scanner reader = new Scanner(new File("users.txt"))) { // Opens "users.txt" for reading.
            while (reader.hasNextLine()) { // Reads the file line by line.
                String line = reader.nextLine(); // Reads the current line.
                if (line.startsWith(username)) { // Checks if the line starts with the username.
                    return true; // Returns true if the username exists.
                }
            }
            return false; // Returns false if the username is not found.
        } catch (IOException e) { // Handles exceptions during file reading.
            System.err.println("Error looking up user: " + e.getMessage()); // Prints the error message.
            return false; // Returns false to indicate failure or missing file.
        }
    }
}
