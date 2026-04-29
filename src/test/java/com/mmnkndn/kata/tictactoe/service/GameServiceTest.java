package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.domain.GameFactory;
import com.mmnkndn.kata.tictactoe.domain.GameSession;
import com.mmnkndn.kata.tictactoe.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameServiceTest {

    @Test
    @DisplayName("Should create a new game with player X")
    void shouldCreateNewGameWithPlayerX() {

        GameFactory gameFactory = mock(GameFactory.class);
        Game game = mock(Game.class);

        when(gameFactory.create()).thenReturn(game);
        when(game.getCurrentPlayer()).thenReturn(Player.X);

        GameService gameService = new GameServiceImpl(gameFactory);

        GameSession gameSession = gameService.createGame();

        assertThat(gameSession).isNotNull();
        assertThat(gameSession.game()).isEqualTo(game);
        assertThat(gameSession.game().getCurrentPlayer()).isEqualTo(Player.X);
        assertThat(gameSession.gameId()).isNotBlank();
    }
}