package com.kodilla.testing.shape;

public class Square implements Shape {

    String shapeName;
    int field;

    public Square(String shapeName, int field) {
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
