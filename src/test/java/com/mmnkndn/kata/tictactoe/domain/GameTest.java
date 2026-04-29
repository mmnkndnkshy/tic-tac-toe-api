package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {

    private final GameFactory gameFactory = new GameFactory(
            new MoveValidator(),
            new GameStatusEvaluator()
    );

    @Test
    @DisplayName("X should always start first")
    void shouldStartWithX() {
        Game game = gameFactory.create();

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }

    @Test
    @DisplayName("game should start with empty board")
    void shouldStartWithEmptyBoard() {
        Game game = gameFactory.create();

        assertThat(game.getBoard()).isEmpty();
    }

    @Test
    @DisplayName("game should be in IN_PROGRESS state initially")
    void shouldStartInProgress() {
        Game game = gameFactory.create();

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.IN_PROGRESS);
    }
}
