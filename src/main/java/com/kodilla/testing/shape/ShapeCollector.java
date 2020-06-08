package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    public ArrayList<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        System.out.println("Adding shape to list");
        this.shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        System.out.println("Removing shape from list");
        this.shapes.remove(shape);
    }

    public void getFigure(int n) {
        System.out.println("Getting shape from list");
        this.shapes.get(n);
    }

    public void showFigures() {

    }
}
