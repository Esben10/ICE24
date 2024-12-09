package org.ICE24;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserShop {
    private ArrayList<Item> items = new ArrayList<Item>();

    public UserShop(){
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

    public void viewAllItems(){
        System.out.println(items);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }






    public void sellItem(){
    }

    public void buyItem(){
    }

    public void searchItem(){
    }

}
