package org.gycoding.exceptions.controller;

import org.gycoding.exceptions.model.APIException;
import org.gycoding.logs.application.service.LogService;
import org.gycoding.logs.model.LogEntity;
import org.gycoding.logs.model.LogLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestControllerAdvice
public class GeneralAdvice {
    @Value("${gy.logs.origin}")
    private final String origin = "";

    @ExceptionHandler({APIException.class})
    public ResponseEntity<String> handleServiceExceptions(APIException ex) {
        LogService.log(LogEntity.builder()
                .id(UUID.randomUUID().toString())
                .message(ex.getMessage())
                .level(LogLevel.ERROR)
                .origin(origin)
                .timestamp(OffsetDateTime.now().toString())
                .build());
        return new ResponseEntity<>(ex.toString(), HttpStatusCode.valueOf(ex.getStatus()));
    }
}
