package org.ICE24;

public abstract class Item {
    public String type;
    public String condition;
    public String description;
    public double price;
    public int size;
    public int id;


    public Item(String type, String condition, String description, double price, int size) {
        this.type = type;
        this.condition = condition;
        this.description = description;
        this.price = price;
        this.size = size;
    }

    public String toString() {

        String formatted = String.format("%8S %8S %32S %6f %1d",this.type, this.condition, this.description, this.price, this.size);
        return formatted + "\n";
        //return this.type + " : " +condition + " : "  + description + " : " + price + " : " + size;
    }



}