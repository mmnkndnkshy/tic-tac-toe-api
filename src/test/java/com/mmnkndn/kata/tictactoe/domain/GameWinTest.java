package com.mmnkndn.kata.tictactoe.domain;

import com.mmnkndn.kata.tictactoe.exception.GameErrorCode;
import com.mmnkndn.kata.tictactoe.exception.GameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameWinTest {

    private final GameFactory gameFactory = new GameFactory(
            new MoveValidator(),
            new GameStatusEvaluator()
    );

    @Test
    @DisplayName("X should win via top row")
    void shouldDeclareXWinRow() {
        Game game = gameFactory.create();

        game.makeMove(0); // X
        game.makeMove(3); // O
        game.makeMove(1); // X
        game.makeMove(4); // O
        game.makeMove(2); // X

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.X_WINS);
    }

    @Test
    @DisplayName("X should win via column")
    void shouldDeclareXWinColumn() {
        Game game = gameFactory.create();

        game.makeMove(0); // X
        game.makeMove(1); // O
        game.makeMove(3); // X
        game.makeMove(2); // O
        game.makeMove(6); // X

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.X_WINS);
    }

    @Test
    @DisplayName("X should win via diagonal")
    void shouldDeclareXWinDiagonal() {
        Game game = gameFactory.create();

        game.makeMove(0); // X
        game.makeMove(1); // O
        game.makeMove(4); // X
        game.makeMove(2); // O
        game.makeMove(8); // X

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.X_WINS);
    }

    @Test
    @DisplayName("O should win via row")
    void shouldDeclareOWinRow() {
        Game game = gameFactory.create();

        game.makeMove(0); // X
        game.makeMove(3); // O
        game.makeMove(1); // X
        game.makeMove(4); // O
        game.makeMove(7); // X
        game.makeMove(5); // O

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.O_WINS);
    }

    @Test
    @DisplayName("O should win via column")
    void shouldDeclareOWinColumn() {
        Game game = gameFactory.create();

        game.makeMove(1); // X
        game.makeMove(0); // O
        game.makeMove(2); // X
        game.makeMove(3); // O
        game.makeMove(4); // X
        game.makeMove(6); // O

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.O_WINS);
    }

    @Test
    @DisplayName("O should win via diagonal")
    void shouldDeclareOWinDiagonal() {
        Game game = gameFactory.create();

        game.makeMove(0); // X
        game.makeMove(2); // O
        game.makeMove(1); // X
        game.makeMove(4); // O
        game.makeMove(3); // X
        game.makeMove(6); // O wins diagonal

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.O_WINS);
    }

    @Test
    @DisplayName("Should not allow moves after O wins")
    void shouldNotAllowMoveAfterOWins() {
        Game game = gameFactory.create();

        game.makeMove(3);
        game.makeMove(0);
        game.makeMove(4);
        game.makeMove(1);
        game.makeMove(6);
        game.makeMove(2); // O wins

        assertThat(game.getGameStatus()).isEqualTo(GameStatus.O_WINS);

        GameException exception = assertThrows(GameException.class,
                () -> game.makeMove(5));

        assertThat(exception.getErrorCode()).isEqualTo(GameErrorCode.GAME_ALREADY_FINISHED);
        assertThat(exception.getMessage()).isEqualTo(GameErrorCode.GAME_ALREADY_FINISHED.getMessage());
    }
}
