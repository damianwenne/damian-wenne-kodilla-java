package com.kodilla.good.patterns.challenges.food2door;

public class Manufacturer implements Order{
    public String manufacturerName;
    public String product;
    public int quantity;

    public Manufacturer(String manufacturerName, String product, int quantity) {
        this.manufacturerName = manufacturerName;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public void process() {
        System.out.println("Ordering: " + product + ", Qty: " + quantity + ", Supplier: " + manufacturerName);
    }
}
