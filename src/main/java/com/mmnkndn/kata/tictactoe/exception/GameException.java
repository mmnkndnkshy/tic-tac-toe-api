package com.mmnkndn.kata.tictactoe.exception;

import lombok.Getter;

@Getter
public class GameException extends RuntimeException {

    private final GameErrorCode errorCode;

    public GameException(GameErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public GameException(GameErrorCode errorCode, String value) {
        super(errorCode.getMessage() + ": " + value);
        this.errorCode = errorCode;
    }
}