package com.mmnkndn.kata.tictactoe.exception;

public class PositionAlreadyOccupiedException extends GameException {

    public PositionAlreadyOccupiedException() {
        super("Position already occupied");
    }

    @Override
    public String getErrorCode() {
        return "POSITION_ALREADY_OCCUPIED";
    }
}
