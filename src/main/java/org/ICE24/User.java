package org.ICE24;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
    public int id;
    public String username;
    public String password;
    public int age;
    public UserShop shop;

    private static int idCounter;


    public User(String username, String password) {
        this.id = User.idCounter++;
        this.username = username;
        this.password = password;
        this.shop = new UserShop(this);
    }

    public boolean saveUser() {
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write( this.id + " : " + this.username + " : " + this.password + System.lineSeparator());
            return true;
        } catch (IOException e) {
            System.err.println("Error saving credentials: " + e.getMessage());
            return false;
        }
    }


    public static void loadIdCounter() {
        int maxId = -1;

        try (Scanner reader = new Scanner(new File("users.txt"))){

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                int id = Integer.parseInt(line.split(":")[0].trim());
                if (id > maxId) {
                    maxId = id;
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while loading users.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("An error occurred while parsing int: " + e.getMessage());
        }

        User.idCounter = maxId + 1;
    }

}
