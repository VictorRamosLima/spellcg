package br.com.spellcg.exceptionhandlers;

import br.com.spellcg.common.ApiError;
import br.com.spellcg.persistence.daos.resources.CardNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class CardExceptionHandler {
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(CardNotFoundException.class)
    public ApiError onCardNotFoundException(CardNotFoundException exception) {
        return new ApiError(
            "CARD_NOT_FOUND",
            Optional.ofNullable(exception.getMessage()).orElse("The card was not found")
        );
    }
}
