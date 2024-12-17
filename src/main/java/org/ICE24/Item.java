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

    public static Item loadItem(String line) {
        try {
            String[] splits = line.split("\\|");
            String type = splits[0].trim();
            String condition = splits[1].trim();
            String description = splits[2].trim();
            double price = Double.parseDouble(splits[3].trim());
            int size = Integer.parseInt(splits[4].trim());

            switch (type) {

                case "Shirt":
                    return new Shirt(condition, description, price, size);

                case "Pants":
                    return new Pants(condition, description, price, size);

                case "Hat":
                    return new Hat(condition, description, price);

                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


}