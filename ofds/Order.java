package com.ofds;

public class Order {
    private Customer customer;
    private FoodItem foodItem;
    private int quantity;

    public Order(Customer customer, FoodItem foodItem, int quantity) {
        this.customer = customer;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public Customer getCustomer() { return customer; }
    public FoodItem getFoodItem() { return foodItem; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "Order by " + customer.getName() + ": " + quantity + " x " + foodItem.getName();
    }
}
