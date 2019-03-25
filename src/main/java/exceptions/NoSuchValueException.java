package exceptions;

public class NoSuchValueException  extends RuntimeException{
    public NoSuchValueException() {
    }

    public NoSuchValueException(String errorMessage) {
        super(errorMessage);
    }
}
