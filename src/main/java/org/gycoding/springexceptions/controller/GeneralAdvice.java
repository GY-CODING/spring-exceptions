package org.gycoding.springexceptions.controller;

import org.gycoding.springexceptions.model.APIError;
import org.gycoding.springexceptions.model.APIException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GeneralAdvice {
    @ExceptionHandler({APIException.class})
    public ResponseEntity<String> handleServiceExceptions(APIException ex) throws APIException {
        System.out.println(ex.toString());
        return new ResponseEntity<>(ex.toString(), HttpStatusCode.valueOf(ex.getStatus()));
    }
}
