package br.com.spellcg.common;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiError {
    private final LocalDateTime timestamp;
    private final String code;
    private final String message;
    private final List<Detail> details;

    public ApiError(String code, String message) {
        this(code, message, Map.of());
    }

    public ApiError(String code, String message, Map<String, String> detailsMap) {
        List<Detail> details = detailsMap
            .entrySet()
            .stream()
            .map(entry -> new Detail(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());

        this.code = code;
        this.message = message;
        this.details = details;
        timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Detail> getDetails() {
        return details;
    }
}
