package com.kodilla.testing.shape;

public class Circle implements Shape {
    String shapeName;
    double radius;

    public Circle(String shapeName, double radius) {
        this.shapeName = shapeName;
        this.radius = radius;
    }
    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return 3.14 * radius * radius;
    }
}
