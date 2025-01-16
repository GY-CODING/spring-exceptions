package org.gycoding.exceptions.controller;

import org.gycoding.exceptions.model.APIException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralAdvice {

    @ExceptionHandler({APIException.class})
    public ResponseEntity<String> handleServiceExceptions(APIException ex) {
        return new ResponseEntity<>(ex.toString(), HttpStatusCode.valueOf(ex.getStatus()));
    }
}
