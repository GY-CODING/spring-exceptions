package org.gycoding.springexceptions;

import lombok.Builder;

@Builder
public class APIException extends Exception {
    private final static String OWNER = "GYCODING";

    private APIError error;

    public APIException(APIError error) {
        super(error.getMessage());
        this.error = error;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"code\": \"%s\"," +
                "\"message\": \"%s\"," +
                "\"owner\": \"%s\"," +
                "\"status\": \"%d\"}",
                error.getCode(), error.getMessage(), OWNER, error.getStatus().value());
    }
}
