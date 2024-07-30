package org.gycoding.springexceptions.controller;

import org.gycoding.springexceptions.model.APIError;
import org.gycoding.springexceptions.model.APIException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GeneralAdvice {
    @ExceptionHandler({APIException.class})
    public void handleServiceExceptions(APIException ex) throws APIException {
        throw ex;
    }
}
