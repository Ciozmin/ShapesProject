package model;

import exception.InvalidShapeException;

public class Cylinder implements Shape {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            throw new InvalidShapeException(
                    "Cylinder radius and height must be positive, got r=" + radius + ", h=" + height);
        }
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return "Cylinder of radius " + radius + ", height " + height
                + " and volume " + volume();
    }
}
