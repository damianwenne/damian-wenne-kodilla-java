package com.kodilla.testing.shape;

public class Triangle implements Shape{

    String shapeName;
    double base;
    double height;

    public Triangle(String shapeName, double base, double height) {
        this.shapeName = shapeName;
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return 0.5 * base * height;
    }
}
