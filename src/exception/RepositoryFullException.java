package exception;

public class RepositoryFullException extends ShapeException {
    public RepositoryFullException(int capacity) {
        super("Repository is full (capacity = " + capacity + ").");
    }
}
