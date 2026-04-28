package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTurnTest {

    @Test
    @DisplayName("X should play first move")
    void shouldStartWithX() {
        Game game = new Game();

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }

    @Test
    @DisplayName("Should switch from player X to player O after a turn")
    void shouldSwitchFromXToO() {
        Game game = new Game();

        game.makeMove(0);

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.O);

    }

    @Test
    @DisplayName("Should switch from player O to player X after a turn")
    void shouldSwitchFromOToX() {
        Game game = new Game();

        game.makeMove(0);
        game.makeMove(1);

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }
}
