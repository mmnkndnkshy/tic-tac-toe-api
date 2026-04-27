package com.mmnkndn.kata.tictactoe.exception;

public abstract class GameException extends RuntimeException {
    public GameException(String message) {
        super(message);
    }

    public abstract String getErrorCode();
}
