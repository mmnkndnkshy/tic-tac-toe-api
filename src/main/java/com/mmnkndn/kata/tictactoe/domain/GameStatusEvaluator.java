package com.mmnkndn.kata.tictactoe.domain;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

@Component
public class GameStatusEvaluator {

    private static final int BOARD_SIZE = 9;

    private static final int[][] WINNING_PATTERNS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    public GameStatus evaluate(Map<Integer, Player> board, Player currentPlayer) {
        if (hasWon(board, currentPlayer)) {
            return currentPlayer == Player.X ? GameStatus.X_WINS : GameStatus.O_WINS;
        }

        if (isDraw(board)) {
            return GameStatus.DRAW;
        }

        return GameStatus.IN_PROGRESS;
    }

    private boolean hasWon(Map<Integer, Player> board, Player player) {
        return Arrays.stream(WINNING_PATTERNS)
                .anyMatch(pattern -> isWinningPattern(board, pattern, player));
    }

    private boolean isWinningPattern(Map<Integer, Player> board, int[] pattern, Player player) {
        return IntStream.of(pattern)
                .allMatch(position -> player.equals(board.get(position)));
    }

    private boolean isDraw(Map<Integer, Player> board) {
        return board.size() == BOARD_SIZE;
    }
}