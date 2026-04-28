package com.mmnkndn.kata.tictactoe.domain;

import com.mmnkndn.kata.tictactoe.exception.GameAlreadyFinishedException;
import com.mmnkndn.kata.tictactoe.exception.InvalidPositionException;
import com.mmnkndn.kata.tictactoe.exception.PositionAlreadyOccupiedException;

import java.util.Map;

public class MoveValidator {

    private static final int BOARD_SIZE = 9;

    public void validate(Game game, int position) {
        validateGameInProgress(game.getGameStatus());
        validatePosition(position);
        validatePositionNotOccupied(game.getBoard(), position);
    }

    private void validateGameInProgress(GameStatus gameStatus) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            throw new GameAlreadyFinishedException();
        }
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= BOARD_SIZE) {
            throw new InvalidPositionException();
        }
    }

    private void validatePositionNotOccupied(Map<Integer, Player> board, int position) {
        if (board.containsKey(position)) {
            throw new PositionAlreadyOccupiedException();
        }
    }
}