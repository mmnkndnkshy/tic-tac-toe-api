package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.repository.GameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    @Test
    @DisplayName("should create a new game with player X")
    void shouldCreateNewGameWithPlayerX() {
        GameRepository gameRepository = new GameRepository();
        GameService gameService = new GameServiceImpl(gameRepository);

        Game game = gameService.createGame();

        assertThat(game.getCurrentPlayer().name()).isEqualTo("X");
    }
}