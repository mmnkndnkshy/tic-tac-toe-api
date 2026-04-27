package com.mmnkndn.kata.tictactoe.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Map<Integer, Player> board = new HashMap<>();

    public Player getCurrentPlayer() {
        return Player.X;
    }

    public void makeMove(int position, Player player) {
        board.put(position, player);
    }

    public Map<Integer, Player> getBoard() {
        return board;
    }
}