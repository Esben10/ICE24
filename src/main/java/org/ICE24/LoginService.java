package org.ICE24;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoginService {
    private static User currentUser;


    public static User getCurrentUser(){
        return currentUser;
    }


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

        User newUser = User.createNewUser(username, password);

        if (newUser.saveUser()) {
            System.out.println("User created successfully!");
        } else {
            System.out.println("Failed to create user. Please try again.");
            return null;
        }
        return newUser;
    }


    public static boolean userExists(String username) {
        try (Scanner reader = new Scanner(new File("users.txt"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String name = line.split(":")[1].trim();
                if (name.equals(username)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            System.err.println("Error looking up user: " + e.getMessage());
            return false;
        }
    }

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Login to your account ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        while (!checkPassword(username, password)) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();

            System.out.print("Enter password: ");
            password = scanner.nextLine();

        }

        currentUser = User.getUser(username);
        return true;

    }

    public static boolean checkPassword(String username1, String password1) {
        try (Scanner reader = new Scanner(new File("users.txt"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] splitLine = line.split(":");
                String username2 = splitLine[1].trim();
                String password2 = splitLine[2].trim();
                if (username1.equals(username2) && password1.equals(password2)) {
                    System.out.println("Login successful!");
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            System.err.println("Error logging in" + e.getMessage());
            return false;
        }
    }

    public static void loadUsers() {
        try {
            Scanner scanner = new Scanner(new File("users.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splits = line.split(":");
                int id = Integer.parseInt(splits[0].trim());
                String username = splits[1].trim();
                String password = splits[2].trim();

                User newUser = new User(username, password, id);
                newUser.shop = UserShop.loadItems(newUser);

                System.out.println(username);
            }


        } catch (Exception e) {
            System.err.println("Error loading users: " + e.getMessage());
        }

    }
}


