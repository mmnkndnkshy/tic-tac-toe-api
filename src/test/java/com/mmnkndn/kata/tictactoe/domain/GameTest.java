package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest
public class GameTest {
    @Test
    @DisplayName("Should create a new game and return the current player as X")
    void shouldCreateNewGameAndReturnCurrentPlayerAsX() {
        Game game = new Game();

        assertThat(game.getCurrentPlayer()).isEqualTo("X");
    }
}
