package br.com.spellcg.configuration;

import br.com.spellcg.common.ApiError;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    private ApiError onException(Exception exception) {
        return new ApiError("INTERNAL_SERVER_ERROR", exception.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError onMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var errors = exception
            .getBindingResult()
            .getAllErrors()
            .stream()
            .map(fieldError ->
                Map.entry(
                    ((FieldError) fieldError).getField(),
                    Optional.ofNullable(fieldError.getDefaultMessage()).orElse("")
                )
            )
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new ApiError("REQUEST_VALIDATION_ERROR", "Some fields are not valid", errors);
    }
}

