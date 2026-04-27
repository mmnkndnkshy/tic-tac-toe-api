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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MoveController.class)
class MoveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GameService gameService;

    @Test
    @DisplayName("Should return updated board after first move")
    void shouldReturnGameStateAfterFirstMove() throws Exception {

        given(gameService.getGame("game-1")).willReturn(new Game());

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.board.0").value("X"))
                .andExpect(jsonPath("$.status").value("IN_PROGRESS"));
    }

    @Test
    @DisplayName("Should return error when position already occupied")
    void shouldReturnErrorForOccupiedPosition() throws Exception {

        Game game = new Game();

        given(gameService.getGame("game-1")).willReturn(game);

        // first move
        mockMvc.perform(post("/games/game-1/moves")
                        .param("position", "0"))
                .andExpect(status().isOk());

        // second move same position
        mockMvc.perform(post("/games/game-1/moves")
                        .param("position", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("POSITION_ALREADY_OCCUPIED"));
    }
}