package io.rugvedmarathe.springbootvalidations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.StringJoiner;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handlerValidationException(ValidationException e) {
        ErrorResponse errorResponse = ErrorResponse.builder().source("Validation").detailedMessage(e.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        ex.getBindingResult().getAllErrors().forEach(objectError -> joiner.add(objectError.getDefaultMessage()));

        ErrorResponse errorResponse = ErrorResponse.builder().source("Validation").detailedMessage(joiner.toString()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
