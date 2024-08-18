package br.bolicos.api.dragons.application.utils;

import br.bolicos.api.dragons.application.exceptions.BadRequestApiException;

import java.util.Optional;

public class Utils {
    public static String getCauseMessage(Exception ex) {
        return Optional.ofNullable(ex.getCause()).map(Throwable::getMessage).orElse("Unknown error");
    }

    public static String getCauseMessageTernary(Exception ex) {
        return (ex.getCause() != null)
                ? ex.getCause().getMessage()
                : """
                Oops! Something went wrong trying to process your request.
                Please try again later or contact the support team.
                """;
    }

    public static void isTrueOrElseThrowBadRequest(boolean value, Throwable ex) {
        Optional.of(value)
                .filter(Boolean.TRUE::equals)
                .orElseThrow(() -> new BadRequestApiException("Bad request, something went wrong", ex));
    }


}
