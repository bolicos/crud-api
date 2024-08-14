package br.bolicos.api.dragons.core.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalHttpExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ResponseEntity<ApiResponse>> handleGenericException(Exception ex) {
        var body = ApiResponse.internalServerError(ex.getMessage(), ex.getLocalizedMessage());
        var payload = ResponseEntity.internalServerError().body(body);
        return Mono.just(payload);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<ApiResponse>> handleIllegalArgumentException(IllegalArgumentException ex) {
        var body = ApiResponse.badRequest(ex.getMessage(), ex.getLocalizedMessage());
        var payload = ResponseEntity.badRequest().body(body);
        return Mono.just(payload);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public Mono<ResponseEntity<ApiResponse>> handleResponseStatusException(ResponseStatusException ex) {
        var status = HttpStatus.valueOf(ex.getStatusCode().value());
        var body = ApiResponse.custom(ex.getMessage(), ex.getLocalizedMessage(), status);
        var payload = ResponseEntity.badRequest().body(body);
        return Mono.just(payload);
    }
}
