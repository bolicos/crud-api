package br.bolicos.api.dragons.application.exceptions;

public class NotFoundApiException extends RuntimeException {

    public NotFoundApiException() {
        super("Resource not found");
    }

    public NotFoundApiException(String message) {
        super(message);
    }

    public NotFoundApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundApiException(Throwable cause) {
        super(cause);
    }
}
