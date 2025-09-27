package com.ofds;

public class DeliveryBoy extends Thread implements Deliverable {
    private Order order;

    public DeliveryBoy(Order order) {
        this.order = order;
    }

    @Override
    public void deliver(Order order) {
        System.out.println("🚴 DeliveryBoy picked up: " + order);
        try {
            Thread.sleep(2000); // simulate delivery time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("✅ Delivered " + order.getFoodItem().getName() +
                " to " + order.getCustomer().getName());
    }

    @Override
    public void run() {
        deliver(order);
    }
}