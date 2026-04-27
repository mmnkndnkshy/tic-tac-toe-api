package com.mmnkndn.kata.tictactoe.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Map<Integer, Player> board = new HashMap<>();
    private Player currentPlayer = Player.X;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Map<Integer, Player> getBoard() {
        return board;
    }

    public void makeMove(int position) {
        board.put(position, currentPlayer);
        switchPlayer();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }

}