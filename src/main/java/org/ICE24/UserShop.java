package org.ICE24; // Defines the package for organizing related classes.

import java.util.ArrayList; // Imports the ArrayList class for dynamic arrays.
import java.util.Locale; // Imports Locale class for internationalization support (unused here).
import java.util.Scanner; // Imports Scanner class for reading input.

public class UserShop { // Defines the main class for the shop system.
    private ArrayList<Item> items = new ArrayList<Item>(); // Stores a list of items in the shop.

    public UserShop(){ // Constructor to initialize the UserShop object.
    }

    public boolean createItem(){ // Method to create a new item based on user input.
        Scanner scanner = new Scanner(System.in); // Creates a scanner object for user input.
        System.out.println("Please enter the following details and separate with + : type + condition + description + price + size"); // Asks user for item details.
        String userInput = scanner.nextLine(); // Reads the user's input as a single line.
        String[] inputSplits = userInput.split("\\+"); // Splits the input into parts based on '+'.
        String type = inputSplits[0].toLowerCase().trim(); // Extracts and normalizes the item type.
        String condition = inputSplits[1].trim(); // Extracts the item's condition.
        String description = inputSplits[2].trim(); // Extracts the item's description.
        double price = Double.parseDouble(inputSplits[3].trim()); // Parses the item's price as a double.
        int size = Integer.parseInt(inputSplits[4].trim()); // Parses the item's size as an integer.

        Item item; // Placeholder for the created item.
        if (type.equals("pants")) { // Checks if the item type is "pants".
            item = new Pants(condition, description, price, size); // Creates a Pants object.
        } else if (type.equals("shirt")) { // Checks if the item type is "shirt".
            item = new Shirt(condition, description, price, size); // Creates a Shirt object.
        } else if (type.equals("hat")) { // Checks if the item type is "hat".
            item = new Hat(condition, description, price); // Creates a Hat object.
        } else { // Handles invalid item types.
            System.out.println("Please enter a valid type"); // Informs the user about invalid input.
            return false; // Returns false to indicate failure.
        }
        addItem(item); // Adds the created item to the shop.
        return true; // Returns true to indicate success.
    }

    public void createItemWithRetries() { // Allows repeated attempts to create an item until successful.
        boolean itemCreated = false; // Tracks whether an item has been created.
        while (!itemCreated) { // Loops until an item is successfully created.
            itemCreated = createItem(); // Calls createItem and updates the status.
        }
    }

    public void viewAllItems(){ // Displays all items in the shop.
        System.out.println(items); // Prints the items list to the console.
    }

    public void addItem(Item item){ // Adds an item to the shop's inventory.
        items.add(item); // Adds the given item to the list.
    }

    public void removeItem(Item item){ // Removes an item from the shop's inventory.
        items.remove(item); // Removes the specified item from the list.
    }

    public void sellItem(){ // Placeholder for selling an item (not implemented yet).
    }

    public void buyItem(){ // Placeholder for buying an item (not implemented yet).
    }

    public void searchItem(){ // Placeholder for searching for an item (not implemented yet).
    }
}
