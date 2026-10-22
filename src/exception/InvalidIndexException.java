package exception;

public class InvalidIndexException extends ShapeException {
    public InvalidIndexException(int index, int size) {
        super("Invalid index " + index + " (valid range: 0.." + (size - 1) + ").");
    }
}
