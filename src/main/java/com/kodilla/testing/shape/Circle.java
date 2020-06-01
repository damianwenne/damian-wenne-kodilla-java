package com.kodilla.testing.shape;

public class Circle implements Shape {
    String shapeName;
    int field;

    public Circle(String shapeName, int field) {
        this.shapeName = shapeName;
        this.field = field;
    }
    @Override
    public String getShapeName() {
        return null;
    }

    @Override
    public int getField() {
        return 0;
    }
}
