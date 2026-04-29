package com.mmnkndn.kata.tictactoe.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Game {

    private final Map<Integer, Player> board = new HashMap<>();
    private final MoveValidator moveValidator;
    private final GameStatusEvaluator gameStatusEvaluator;

    private Player currentPlayer = Player.X;
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    public void makeMove(int position) {
        moveValidator.validate(this, position);

        placeMove(position);
        gameStatus = gameStatusEvaluator.evaluate(board, currentPlayer);

        if (gameStatus == GameStatus.IN_PROGRESS) {
            switchPlayer();
        }
    }

    private void placeMove(int position) {
        board.put(position, currentPlayer);
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == Player.X ? Player.O : Player.X;
    }
}