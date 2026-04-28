package com.mmnkndn.kata.tictactoe.exception;

public class GameNotFoundException extends GameException {

    public GameNotFoundException(String gameId) {
        super("Game not found: " + gameId);
    }

    @Override
    public String getErrorCode() {
        return "GAME_NOT_FOUND";
    }
}
