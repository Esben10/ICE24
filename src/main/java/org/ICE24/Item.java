package org.ICE24;

public abstract class Item {
    public String type;
    private String condition;
    private String description;
    private double price;
    private int size;


    public Item(String type, String condition, String description, double price, int size) {
        this.type = type;
        this.condition = condition;
        this.description = description;
        this.price = price;
        this.size = size;

    }

    public String toString() {
        return this.type + " : " +condition + " : "  + description + " : " + price + " : " + size;
    }



}