package org.gycoding.exceptions.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum APIError {
    BAD_REQUEST("Request validation has thrown an error, the request is malformed.", HttpStatus.BAD_REQUEST),
    SERVER_ERROR("An internal server error has occurred, sorry for the inconvenience.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus status;

    APIError(String message, HttpStatus status) {
        this.code       = this.name();
        this.message    = message;
        this.status     = status;
    }
}
