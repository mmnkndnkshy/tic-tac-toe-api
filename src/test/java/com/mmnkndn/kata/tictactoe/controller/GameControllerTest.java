package com.mmnkndn.kata.tictactoe.controller;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.domain.GameCreated;
import com.mmnkndn.kata.tictactoe.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GameService gameService;

    @Test
    @DisplayName("Should create a new game and return player X")
    void shouldCreateGame() throws Exception {

        Game game = new Game();
        GameCreated gameCreated = new GameCreated("game-1", game);

        when(gameService.createGame()).thenReturn(gameCreated);

        mockMvc.perform(post("/games"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.currentPlayer").value("X"))
                .andExpect(jsonPath("$.gameId").value("game-1"));
    }

    @Test
    @DisplayName("Should make a move and return updated board")
    void shouldMakeMove() throws Exception {
        Game game = new Game();

        when(gameService.getGame("game-1")).thenReturn(game);

        mockMvc.perform(post("/games/game-1/moves")
                        .param("position", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.board.0").value("X"))
                .andExpect(jsonPath("$.status").value("IN_PROGRESS"));
    }

    @Test
    @DisplayName("Should return bad request when position is already occupied")
    void shouldReturnErrorForOccupiedPosition() throws Exception {
        Game game = new Game();
        game.makeMove(0);

        when(gameService.getGame("game-1")).thenReturn(game);

        mockMvc.perform(post("/games/game-1/moves")
                        .param("position", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Position already occupied"))
                .andExpect(jsonPath("$.error").value("POSITION_ALREADY_OCCUPIED"));
    }
}
