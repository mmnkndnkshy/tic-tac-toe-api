package com.mmnkndn.kata.tictactoe.domain;

import com.mmnkndn.kata.tictactoe.exception.GameErrorCode;
import com.mmnkndn.kata.tictactoe.exception.GameException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MoveValidator {

    private static final int BOARD_SIZE = 9;

    public void validate(Game game, int position) {
        validatePosition(position);
        validatePositionNotOccupied(game.getBoard(), position);
        validateGameInProgress(game.getGameStatus());
    }

    private void validateGameInProgress(GameStatus gameStatus) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            throw new GameException(GameErrorCode.GAME_ALREADY_FINISHED);
        }
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= BOARD_SIZE) {
            throw new GameException(GameErrorCode.INVALID_POSITION);
        }
    }

    private void validatePositionNotOccupied(Map<Integer, Player> board, int position) {
        if (board.containsKey(position)) {
            throw new GameException(GameErrorCode.POSITION_ALREADY_OCCUPIED);
        }
    }
}