package io.github.henrik13.usedcarmarket.exception;

import io.github.henrik13.usedcarmarket.dto.error.ValidationErrorResponse;
import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final ValidationErrorResponse errorResponse;

    public ValidationException(ValidationErrorResponse errorResponse) {
        super("Validation error occurred");
        this.errorResponse = errorResponse;
    }

    public ValidationException(String message, ValidationErrorResponse errorResponse) {
        super(message);
        this.errorResponse = errorResponse;
    }

}
