package org.ICE24;

public class Pants extends Item {
    private final String type = "Pants";

    public Pants(String depreciation, String description, double price, int size) {
        super("Pants", depreciation, description, price, size);
    }
}