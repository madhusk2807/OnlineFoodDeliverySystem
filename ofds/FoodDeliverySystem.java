package com.ofds;

import java.util.*;

public class FoodDeliverySystem {
    private static HashMap<Integer, FoodItem> menu = new HashMap<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize menu
        menu.put(1, new FoodItem(1, "Pizza", 250, 5));
        menu.put(2, new FoodItem(2, "Burger", 120, 10));
        menu.put(3, new FoodItem(3, "Pasta", 200, 7));
        menu.put(4, new FoodItem(4, "Sandwich", 80, 8));

        System.out.print("Enter your name: ");
        String customerName = sc.nextLine();
        Customer customer = new Customer(customerName);

        boolean ordering = true;

        while (ordering) {
            System.out.println("\n------ MENU ------");
            for (FoodItem item : menu.values()) {
                System.out.println(item);
            }

            try {
                System.out.print("Enter food id to order: ");
                int choice = sc.nextInt();

                if (!menu.containsKey(choice)) {
                    throw new InvalidMenuChoiceException("❌ Invalid menu choice!");
                }

                FoodItem item = menu.get(choice);

                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                if (qty > item.getStock()) {
                    throw new OutOfStockException("❌ Not enough stock available!");
                }

                item.reduceStock(qty);
                Order order = new Order(customer, item, qty);
                orders.add(order);

                // Create DeliveryBoy (implements Deliverable)
                Deliverable deliverer = new DeliveryBoy(order);
                ((Thread) deliverer).start();

            } catch (InvalidMenuChoiceException | OutOfStockException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter numbers only!");
                sc.next(); // clear invalid input
            }

            System.out.print("Do you want to order more? (yes/no): ");
            ordering = sc.next().equalsIgnoreCase("yes");
        }

        sc.close();
        System.out.println("\n📦 All Orders Placed. Deliveries in progress...");
    }
}
