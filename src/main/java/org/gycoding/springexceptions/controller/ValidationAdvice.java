package org.gycoding.springexceptions.controller;

import org.gycoding.springexceptions.model.APIError;
import org.gycoding.springexceptions.model.APIException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ValidationAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public void handleValidationExceptions(MethodArgumentNotValidException ex) throws APIException {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        throw new APIException(APIError.BAD_REQUEST.getCode(), errors.get(errors.size() - 1), APIError.BAD_REQUEST.getStatus());
    }
}
