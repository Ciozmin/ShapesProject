package repository;

import exception.InvalidIndexException;
import exception.RepositoryFullException;
import model.Shape;

import java.util.Arrays;

public class ArrayRepository implements Repository {
    private final Shape[] elements;
    private int size;

    public ArrayRepository(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.elements = new Shape[capacity];
        this.size = 0;
    }

    @Override
    public void add(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Cannot add a null shape.");
        }
        if (size == elements.length) {
            throw new RepositoryFullException(elements.length);
        }
        elements[size++] = shape;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    @Override
    public Shape get(int index) {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Shape[] getAll() {
        return Arrays.copyOf(elements, size);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException(index, size);
        }
    }
}
