package org.gycoding.springexceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum APIError {
    HOME_NOT_FOUND("API reference not found.", HttpStatus.NOT_FOUND),
    I_AM_A_TEAPOT("What? I'm a teapot!.", HttpStatus.I_AM_A_TEAPOT),

    BAD_REQUEST("The endpoint is malformed.", HttpStatus.BAD_REQUEST),
    SERVER_ERROR("An internal server error has occurred, sorry for the inconvenience.", HttpStatus.INTERNAL_SERVER_ERROR);

    public final String code;
    public final String message;
    public final HttpStatus status;

    APIError(String message, HttpStatus status) {
        this.code       = this.name();
        this.message    = message;
        this.status     = status;
    }
}
