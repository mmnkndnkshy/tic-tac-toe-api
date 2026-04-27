package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    @Test
    @DisplayName("Should start a new game with player X")
    void shouldStartNewGameWithPlayerX() {
        Game game = new Game();

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }
}
