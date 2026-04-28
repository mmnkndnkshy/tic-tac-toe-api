package com.mmnkndn.kata.tictactoe.domain;

import com.mmnkndn.kata.tictactoe.exception.GameAlreadyFinishedException;
import com.mmnkndn.kata.tictactoe.exception.InvalidPositionException;
import com.mmnkndn.kata.tictactoe.exception.PositionAlreadyOccupiedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameMoveValidationTest {

    @Test
    @DisplayName("should reject position less than 0")
    void shouldRejectNegativePosition() {

        Game game = new Game();

        assertThrows(InvalidPositionException.class, () -> game.makeMove(-1));

    }

    @Test
    @DisplayName("should reject position greater than 8")
    void shouldRejectTooLargePosition() {

        Game game = new Game();

        assertThrows(InvalidPositionException.class, () -> game.makeMove(9));

    }

    @Test
    @DisplayName("should reject move on occupied position")
    void shouldRejectOccupiedPosition() {

        Game game = new Game();

        game.makeMove(0);

        assertThrows(PositionAlreadyOccupiedException.class, () -> game.makeMove(0));

    }

    @Test
    @DisplayName("should reject move after game is finished")
    void shouldRejectMoveAfterGameFinished() {
        Game game = new Game();

        game.makeMove(0);
        game.makeMove(3);
        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(2); // X wins

        assertThrows(GameAlreadyFinishedException.class,
                () -> game.makeMove(5));
    }
}
