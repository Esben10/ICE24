package org.ICE24;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public int id;
    public String username;
    public String password;
    public UserShop shop;

    private static int idCounter;
    protected static ArrayList<User> allUsers = new ArrayList<>();


    public User(String username, String password, int id) {

        this.username = username;
        this.password = password;
        this.id = id;
        this.shop = null;
        allUsers.add(this);
    }

    public String toString(){
        return username;
    }


    public static User createNewUser(String username, String password) {

        User newUser = new User(username, password, User.idCounter++);
        newUser.shop = UserShop.createNewUserShop(newUser);
        return newUser;
    }

    public static User getUser(String username) {
        for (User user : allUsers) {
            if (username.equals(user.username)) {
                return user;
            }
        }
        return null;
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
