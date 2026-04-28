package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameDrawTest {

    @Test
    @DisplayName("should declare draw when board is full with no winner")
    void shouldDeclareDraw() {
        Game game = new Game();

        game.makeMove(0);
        game.makeMove(1);
        game.makeMove(2);
        game.makeMove(4);
        game.makeMove(3);
        game.makeMove(5);
        game.makeMove(7);
        game.makeMove(6);
        game.makeMove(8);

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.DRAW);
    }

}