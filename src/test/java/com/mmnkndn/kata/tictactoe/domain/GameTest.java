package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    @Test
    @DisplayName("X should always start first")
    void shouldStartWithX() {
        Game game = new Game();

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }

    @Test
    @DisplayName("game should start with empty board")
    void shouldStartWithEmptyBoard() {
        Game game = new Game();

        assertThat(game.getBoard()).isEmpty();
    }

    @Test
    @DisplayName("game should be in IN_PROGRESS state initially")
    void shouldStartInProgress() {
        Game game = new Game();

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.IN_PROGRESS);
    }
}
