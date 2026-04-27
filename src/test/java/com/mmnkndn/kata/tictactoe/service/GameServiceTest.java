package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    @Test
    @DisplayName("should create a new game with player X")
    void shouldCreateNewGameWithPlayerX() {
        GameService gameService = new GameServiceImpl();

        Game game = gameService.createGame();

        assertThat(game.getCurrentPlayer().name()).isEqualTo("X");
    }
}