package com.mmnkndn.kata.tictactoe.domain;

import com.mmnkndn.kata.tictactoe.exception.GameErrorCode;
import com.mmnkndn.kata.tictactoe.exception.GameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameMoveValidationTest {

    private final GameFactory gameFactory = new GameFactory(
            new MoveValidator(),
            new GameStatusEvaluator()
    );

    @Test
    @DisplayName("should reject position less than 0")
    void shouldRejectNegativePosition() {

        Game game = gameFactory.create();

        GameException exception = assertThrows(GameException.class,
                () -> game.makeMove(-1));

        assertThat(exception.getErrorCode()).isEqualTo(GameErrorCode.INVALID_POSITION);
        assertThat(exception.getMessage()).isEqualTo(GameErrorCode.INVALID_POSITION.getMessage());


    }

    @Test
    @DisplayName("should reject position greater than 8")
    void shouldRejectTooLargePosition() {

        Game game = gameFactory.create();

        GameException exception = assertThrows(GameException.class,
                () -> game.makeMove(9));

        assertThat(exception.getErrorCode()).isEqualTo(GameErrorCode.INVALID_POSITION);
        assertThat(exception.getMessage()).isEqualTo(GameErrorCode.INVALID_POSITION.getMessage());

    }

    @Test
    @DisplayName("should reject move on occupied position")
    void shouldRejectOccupiedPosition() {

        Game game = gameFactory.create();

        game.makeMove(0);

        GameException exception = assertThrows(GameException.class,
                () -> game.makeMove(0));

        assertThat(exception.getErrorCode()).isEqualTo(GameErrorCode.POSITION_ALREADY_OCCUPIED);
        assertThat(exception.getMessage()).isEqualTo(GameErrorCode.POSITION_ALREADY_OCCUPIED.getMessage());

    }

    @Test
    @DisplayName("should reject move after game is finished")
    void shouldRejectMoveAfterGameFinished() {
        Game game = gameFactory.create();

        game.makeMove(0);
        game.makeMove(3);
        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(2); // X wins

        GameException exception = assertThrows(GameException.class,
                () -> game.makeMove(5));

        assertThat(exception.getErrorCode()).isEqualTo(GameErrorCode.GAME_ALREADY_FINISHED);
        assertThat(exception.getMessage()).isEqualTo(GameErrorCode.GAME_ALREADY_FINISHED.getMessage());
    }
}
