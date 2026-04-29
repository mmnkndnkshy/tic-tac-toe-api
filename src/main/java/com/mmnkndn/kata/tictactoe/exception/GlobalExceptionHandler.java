package com.mmnkndn.kata.tictactoe.exception;

import com.mmnkndn.kata.tictactoe.api.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GameException.class)
    public ResponseEntity<ErrorResponse> handleGameException(GameException ex) {

        return ResponseEntity.badRequest().body(
                new ErrorResponse()
                        .message(ex.getMessage())
                        .error(ex.getErrorCode().getCode())
        );
    }
}