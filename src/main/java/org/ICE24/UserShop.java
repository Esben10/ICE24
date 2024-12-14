package org.ICE24;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class UserShop {
    public static ArrayList<UserShop> allUserShops = new ArrayList<>();

    private final ArrayList<Item> items;
    public User owner;

    public UserShop(User user){
        this.items = new ArrayList<Item>();
        this.owner = user;
        allUserShops.add(this);
    }

    public boolean createItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the following details and separate with + : type + condition + description + price + size");
        String userInput = scanner.nextLine();
        String[] inputSplits = userInput.split("\\+");
        String type = inputSplits[0].toLowerCase().trim();
        String condition = inputSplits[1].trim();
        String description = inputSplits[2].trim();
        double price = Double.parseDouble(inputSplits[3].trim());
        int size = Integer.parseInt(inputSplits[4].trim());


        Item item;
        if (type.equals("pants")) {
            item = new Pants(condition, description, price, size);
        } else if (type.equals("shirt")) {
            item = new Shirt(condition, description, price, size);
        } else if (type.equals("hat")) {
            item = new Hat(condition, description, price);
        } else {
            System.out.println("Please enter a valid type");
            return false;
        }
        addItem(item);
        return true;
    }

    public void createItemWithRetries() {
        boolean itemCreated = false;
        while (!itemCreated) {
            itemCreated = createItem();
        }
    }

    public void viewItems(){
        for (Item item : items) {
            String itemFormat = "%-8s | %-12s | %-32s | %6s | %4s";
            System.out.printf((itemFormat) + "%n", item.type, item.condition, item.description, item.price, item.size);
        }


    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }




    public void saveItems(){
        try (FileWriter writer = new FileWriter(owner.username + "_items.txt", false)) {
            writer.write("USER NAME: " + owner.username + "\n");
            writer.write("USER ID: " + owner.id + "\n\n");
            String format = "%-8s | %-12s | %-32s | %6s | %4s \n\n";
            String formatted = String.format(format, "TYPE", "CONDITION", "DESCRIPTION", "PRICE", "SIZE");
            writer.write(formatted);

            for (Item item : items) {
                String formattedItem = String.format(format, item.type, item.condition, item.description, item.price, item.size);
                writer.write(formattedItem);
            }

        } catch (IOException e) {
            System.out.println("failed to save items");
        }
    }


    public void sellItem(){
    }

    public void buyItem(){
    }

    public void searchItem(){
    }

    public static void viewAllItems(){
        for (UserShop us : allUserShops){
            us.viewItems();
        }
    }



}






