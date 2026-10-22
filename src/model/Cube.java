package model;

import exception.InvalidShapeException;

public class Cube implements Shape {
    private final double side;

    public Cube(double side) {
        if (side <= 0) {
            throw new InvalidShapeException("Cube side must be positive, got " + side);
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }

    @Override
    public String toString() {
        return "Cube of side " + side + " and volume " + volume();
    }
}
