package com.mmnkndn.kata.tictactoe.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GameErrorCode {

    INVALID_POSITION("INVALID_POSITION", "Invalid position"),
    POSITION_ALREADY_OCCUPIED("POSITION_ALREADY_OCCUPIED", "Position already occupied"),
    GAME_ALREADY_FINISHED("GAME_ALREADY_FINISHED", "Game already finished"),
    GAME_NOT_FOUND("GAME_NOT_FOUND", "Game not found");

    private final String code;
    private final String message;
}