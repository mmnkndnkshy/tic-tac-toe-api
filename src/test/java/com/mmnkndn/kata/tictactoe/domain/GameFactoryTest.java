package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameFactoryTest {

    @Test
    @DisplayName("Should create a new game with player X")
    void shouldCreateNewGameWithPlayerX() {
        GameFactory gameFactory = new GameFactory(
                new MoveValidator(),
                new GameStatusEvaluator()
        );

        Game game = gameFactory.create();

        assertThat(game).isNotNull();
        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.IN_PROGRESS);
        assertThat(game.getBoard()).isEmpty();
    }
}