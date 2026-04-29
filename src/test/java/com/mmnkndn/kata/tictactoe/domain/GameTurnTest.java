package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTurnTest {

    private final GameFactory gameFactory = new GameFactory(
            new MoveValidator(),
            new GameStatusEvaluator()
    );

    @Test
    @DisplayName("X should play first move")
    void shouldStartWithX() {
        Game game = gameFactory.create();

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }

    @Test
    @DisplayName("Should switch from player X to player O after a turn")
    void shouldSwitchFromXToO() {
        Game game = gameFactory.create();

        game.makeMove(0);

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.O);

    }

    @Test
    @DisplayName("Should switch from player O to player X after a turn")
    void shouldSwitchFromOToX() {
        Game game = gameFactory.create();

        game.makeMove(0);
        game.makeMove(1);

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }
}
