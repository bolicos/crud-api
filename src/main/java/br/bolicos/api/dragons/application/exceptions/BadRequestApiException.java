package br.bolicos.api.dragons.application.exceptions;

public class BadRequestApiException extends RuntimeException {
    public BadRequestApiException() {
        super("Bad request, something went wrong");
    }

    public BadRequestApiException(String message) {
        super(message);
    }

    public BadRequestApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestApiException(Throwable cause) {
        super(cause);
    }
}