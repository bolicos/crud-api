package br.bolicos.api.dragons.infraestructure.http.config;

import br.bolicos.api.dragons.application.exceptions.BadRequestApiException;
import br.bolicos.api.dragons.application.exceptions.NotFoundApiException;
import br.bolicos.api.dragons.infraestructure.http.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import static br.bolicos.api.dragons.application.utils.Utils.getCauseMessage;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class HttpExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, BadRequestApiException.class})
    public Mono<ApiResponse> handleIllegalArgumentException(Exception ex, ServerWebExchange exchange) {
        var cause = getCauseMessage(ex);
        var payload = ApiResponse.badRequest(ex.getMessage(), cause);

        return Mono.just(payload);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundApiException.class)
    public Mono<ApiResponse> handleEntityNotFoundException(NotFoundApiException ex) {
        var cause = getCauseMessage(ex);
        var payload = ApiResponse.notFound(ex.getMessage(), cause);

        return Mono.just(payload);
    }

    @ResponseStatus(METHOD_NOT_ALLOWED)
    @ExceptionHandler(MethodNotAllowedException.class)
    public Mono<ApiResponse> handleMethodNotAllowedException(MethodNotAllowedException ex) {
        var cause = getCauseMessage(ex);
        var payload = ApiResponse.custom(ex.getReason(), cause, METHOD_NOT_ALLOWED);

        return Mono.just(payload);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ServerWebInputException.class)
    public Mono<ApiResponse> handleServerWebInputException(ServerWebInputException ex) {
        var cause = getCauseMessage(ex);
        var payload = ApiResponse.custom(ex.getReason(), cause, BAD_REQUEST);

        return Mono.just(payload);
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResponseStatusException.class)
    public Mono<ApiResponse> handleResponseStatusException(ResponseStatusException ex) {
        var cause = getCauseMessage(ex);
        var status = HttpStatus.valueOf(ex.getStatusCode().value());

        System.out.println(status); // Check it, replace by Logger.

        var payload = ApiResponse.custom(ex.getMessage(), cause, INTERNAL_SERVER_ERROR);
        return Mono.just(payload); // Check Mono.error, replace by Mono.just(data).
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public Mono<ApiResponse> handleGenericException(Exception ex) {
        var cause = getCauseMessage(ex);
        var payload = ApiResponse.internalServerError(ex.getMessage(), cause);

        return Mono.just(payload);
    }

}
