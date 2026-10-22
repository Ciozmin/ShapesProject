package repository;

import model.Shape;

public interface Repository {
    void add(Shape shape);

    void remove(int index);

    Shape get(int index);

    int size();

    Shape[] getAll();
}
