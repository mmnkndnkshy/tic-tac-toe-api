package com.mmnkndn.kata.tictactoe.exception;

public class GameAlreadyFinishedException extends GameException {

    public GameAlreadyFinishedException() {
        super("Game already finished");
    }

    @Override
    public String getErrorCode() {
        return "GAME_ALREADY_FINISHED";
    }
}
