package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.domain.GameCreated;
import com.mmnkndn.kata.tictactoe.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    @Test
    @DisplayName("Should create a new game with player X")
    void shouldCreateNewGameWithPlayerX() {

        GameService gameService = new GameServiceImpl();

        GameCreated created = gameService.createGame();

        Game game = created.game();

        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }
}