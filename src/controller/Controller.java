package controller;

import model.Shape;
import repository.Repository;

import java.util.Arrays;

public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    public void addShape(Shape shape) {
        repository.add(shape);
    }

    public void removeShape(int index) {
        repository.remove(index);
    }

    public Shape[] getAllShapes() {
        return repository.getAll();
    }

    public Shape[] getShapesWithVolumeGreaterThan(double limit) {
        Shape[] all = repository.getAll();
        Shape[] result = new Shape[all.length];
        int count = 0;
        for (Shape s : all) {
            if (s.volume() > limit) {
                result[count++] = s;
            }
        }
        return Arrays.copyOf(result, count);
    }
}
