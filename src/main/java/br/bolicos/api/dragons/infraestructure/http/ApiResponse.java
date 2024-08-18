package br.bolicos.api.dragons.infraestructure.http;

import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
public record ApiResponse(LocalDateTime timestamp, HttpStatus status, int statusCode, String message, String cause) {
    public static ApiResponse custom(String message, String cause, HttpStatus status) {
        return ApiResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .statusCode(status.value())
                .message(message)
                .cause(cause)
                .build();
    }

    public static ApiResponse notFound(String message, String cause) {
        return ApiResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(message)
                .cause(cause)
                .build();
    }

    public static ApiResponse internalServerError(String message, String cause) {
        return ApiResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(message)
                .cause(cause)
                .build();
    }

    public static ApiResponse badRequest(String message, String cause) {
        return ApiResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(message)
                .cause(cause)
                .build();
    }
}