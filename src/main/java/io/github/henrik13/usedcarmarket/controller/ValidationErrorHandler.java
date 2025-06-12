package io.github.henrik13.usedcarmarket.controller;

import io.github.henrik13.usedcarmarket.dto.error.ValidationErrorResponse;
import io.github.henrik13.usedcarmarket.exception.CarNotFoundException;
import io.github.henrik13.usedcarmarket.exception.ValidationException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ValidationErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleConstraintViolation(ConstraintViolationException e) {
        log.debug("ConstraintViolationException occurred", e);
        ValidationErrorResponse errors = new ValidationErrorResponse();

        e.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.addError(fieldName, message);
        });

        return errors;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        log.debug("MethodArgumentNotValidException occurred", e);
        ValidationErrorResponse errors = new ValidationErrorResponse();

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String fieldName = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errors.addError(fieldName, message);
        });

        return errors;
    }

    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ValidationErrorResponse handleCarNotFound(CarNotFoundException e) {
        log.debug("CarNotFoundException occurred", e);
        ValidationErrorResponse errors = new ValidationErrorResponse();
        errors.addError("id", "Car not found");
        return errors;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleValidationException(ValidationException e) {
        log.debug("ValidationException occurred", e);
        return e.getErrorResponse();
    }
}
