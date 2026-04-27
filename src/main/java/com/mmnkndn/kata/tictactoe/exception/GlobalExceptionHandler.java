package com.mmnkndn.kata.tictactoe.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GameException.class)
    public ResponseEntity<?> handleGameException(GameException ex) {

        return ResponseEntity.badRequest().body(
                Map.of(
                        "error", ex.getErrorCode(),
                        "message", ex.getMessage()
                )
        );
    }
}