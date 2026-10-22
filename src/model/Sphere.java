package model;

import exception.InvalidShapeException;

public class Sphere implements Shape {
    private final double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            throw new InvalidShapeException("Sphere radius must be positive, got " + radius);
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double volume() {
        return 4.0 / 3.0 * Math.PI * radius * radius * radius;
    }

    @Override
    public String toString() {
        return "Sphere of radius " + radius + " and volume " + volume();
    }
}
