package com.kodilla.good.patterns.challenges.food2door;

public class Application {
    public static void main(String[] args) {
        Manufacturer extraFoodShop = new Manufacturer("Extra Food Shop", "Apple", 12);
        Manufacturer healthyShop = new Manufacturer("Healthy Shop", "Vege Burger", 10);
        Manufacturer glutenFreeShop = new Manufacturer("Gluten Free Shop", "Gluten Free Beer", 45);

        extraFoodShop.process();
        healthyShop.process();
        glutenFreeShop.process();
    }
}
