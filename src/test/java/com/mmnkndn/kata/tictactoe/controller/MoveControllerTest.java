package com.mmnkndn.kata.tictactoe.controller;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MoveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GameService gameService;

    @Test
    @DisplayName("should allow player X to place a mark at position 0")
    void shouldAllowPlayerXToPlaceMarkAtPosition0() throws Exception {

        Game game = new Game();

        given(gameService.getGame("game-1")).willReturn(game);

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.board.0").value("X"));
    }

    @Test
    @DisplayName("should allow multiple moves in same game and persist state")
    void shouldSwitchPlayerFromXToOAfterFirstMove() throws Exception {

        Game game = new Game();

        given(gameService.getGame("game-1")).willReturn(game);

        // First move
        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.board.0").value("X"));

        // Second move
        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.board.1").value("O")); // THIS SHOULD PASS
    }
}