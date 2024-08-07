package org.gycoding.exceptions.controller;

import org.gycoding.exceptions.model.APIError;
import org.gycoding.exceptions.model.APIException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        final var exception = new APIException(
                APIError.BAD_REQUEST.getCode(),
                String.join(", ", errors),
                APIError.BAD_REQUEST.getStatus().value()
        );

        return new ResponseEntity<>(exception.toString(), HttpStatusCode.valueOf(exception.getStatus()));
    }
}
