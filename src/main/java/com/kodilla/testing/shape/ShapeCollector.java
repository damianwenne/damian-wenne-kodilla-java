package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        System.out.println("Adding shape to list");
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        System.out.println("Removing shape from list");
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        System.out.println("Getting shape from list");
        return shapes.get(n);
    }

    public ArrayList<Shape> showFigures() {
        return shapes;
    }
}
