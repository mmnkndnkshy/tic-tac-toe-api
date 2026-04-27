package com.mmnkndn.kata.tictactoe.exception;

public class InvalidPositionException extends GameException {

    public InvalidPositionException() {
        super("Invalid board position");
    }

    @Override
    public String getErrorCode() {
        return "INVALID_POSITION";
    }
}
