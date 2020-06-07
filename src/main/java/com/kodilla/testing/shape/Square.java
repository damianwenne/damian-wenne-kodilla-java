package com.kodilla.testing.shape;

public class Square implements Shape {

    String shapeName;
    double side;

    public Square(String shapeName, double side) {
        this.shapeName = shapeName;
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return side * side;
    }
}
