package com.mmnkndn.kata.tictactoe.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Map<Integer, Player> board = new HashMap<>();
    private Player currentPlayer = Player.X;
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    private static final int[][] WINNING_PATTERNS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}              // diagonals
    };

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Map<Integer, Player> getBoard() {
        return board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void makeMove(int position) {
        validatePosition(position);

        if (board.containsKey(position)) {
            throw new IllegalArgumentException("Position already occupied");
        }

        board.put(position, currentPlayer);

        if (hasWon(currentPlayer)) {
            gameStatus = (currentPlayer == Player.X)
                    ? GameStatus.X_WINS
                    : GameStatus.O_WINS;
            return;
        }

        switchPlayer();
    }

    private boolean hasWon(Player player) {

        for (int[] pattern : WINNING_PATTERNS) {
            if (isWinningPattern(pattern, player)) {
                return true;
            }
        }

        return false;
    }

    private boolean isWinningPattern(int[] pattern, Player player) {
        return player.equals(board.get(pattern[0])) &&
                player.equals(board.get(pattern[1])) &&
                player.equals(board.get(pattern[2]));
    }

    private void validatePosition(int position) {
        if (position < 0 || position > 8) {
            throw new IllegalArgumentException("Invalid board position");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }

}