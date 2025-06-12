package io.github.henrik13.usedcarmarket.dto.error;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorResponse {
    private final List<ValidationError> errors;

    public ValidationErrorResponse() {
        this.errors = new ArrayList<>();
    }

    public void addError(String field, String message) {
        this.errors.add(new ValidationError(field, message));
    }

    public record ValidationError(String field, String message) {

    }
}
