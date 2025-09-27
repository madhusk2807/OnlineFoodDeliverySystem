package com.ofds;

public class FoodItem {
    private int id;
    private String name;
    private double price;
    private int stock;

    public FoodItem(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock(int qty) {
        this.stock -= qty;
    }

    @Override
    public String toString() {
        return id + ". " + name + " (₹" + price + ") - Stock: " + stock;
    }
}
