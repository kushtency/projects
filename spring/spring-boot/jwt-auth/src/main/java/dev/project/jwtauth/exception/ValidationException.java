package dev.project.jwtauth.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationException extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            HttpStatusCode status,
            @NonNull WebRequest request
    ) {
        Map<String, Object> object = new HashMap<>();
        object.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        ex
                .getAllErrors()
                .forEach(error -> {
                    String name = ((FieldError) error).getField();
                    String value = error.getDefaultMessage();
                    object.put(name, value);
                });
        return ResponseEntity.badRequest().body(object);
    }
}
