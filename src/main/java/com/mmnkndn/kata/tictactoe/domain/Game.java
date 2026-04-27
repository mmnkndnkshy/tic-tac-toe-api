package com.mmnkndn.kata.tictactoe.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Map<Integer, Player> board = new HashMap<>();
    private Player currentPlayer = Player.X;
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

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

        return check(0, 1, 2, player) ||
                check(3, 4, 5, player) ||
                check(6, 7, 8, player);
    }

    private boolean check(int a, int b, int c, Player player) {
        return player.equals(board.get(a)) &&
                player.equals(board.get(b)) &&
                player.equals(board.get(c));
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