package io.github.henrik13.usedcarmarket.exception;

public class CarNotFoundException extends Exception {
    public CarNotFoundException() {
        super();
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}
