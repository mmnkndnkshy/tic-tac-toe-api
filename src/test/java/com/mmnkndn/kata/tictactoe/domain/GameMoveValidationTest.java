package com.mmnkndn.kata.tictactoe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameMoveValidationTest {

    @Test
    @DisplayName("Should reject move to an occupied position")
    void shouldRejectOccupiedPosition(){

      Game game = new Game();

      game.makeMove(0);

      assertThrows(IllegalArgumentException.class, () -> game.makeMove(0));

    }

    @Test
    @DisplayName("Should reject move to an invalid negative position")
    void shouldRejectInvalidLowPosition(){

      Game game = new Game();

      assertThrows(IllegalArgumentException.class, () -> game.makeMove(-1));

    }

    @Test
    @DisplayName("Should reject move to an invalid high position")
    void shouldRejectMoveToInvalidHighPosition(){

      Game game = new Game();

      assertThrows(IllegalArgumentException.class, () -> game.makeMove(9));

    }
}
