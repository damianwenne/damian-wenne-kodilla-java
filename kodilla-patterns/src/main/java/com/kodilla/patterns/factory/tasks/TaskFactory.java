package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case PAINTING:
                return new PaintingTask("Painting", "Orange", "Room");
            case SHOPPING:
                return new ShoppingTask("Shopping", "Tomatoes", 3.0);
            case DRIVING:
                return new DrivingTask("Driving", "Wrocław", "car");
            default:
                return null;
        }

    }
}
