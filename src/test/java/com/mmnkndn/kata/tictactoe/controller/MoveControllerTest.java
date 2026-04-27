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

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.board.0").value("X"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.board.1").value("O"));
    }

    @Test
    @DisplayName("should not allow player to move to an occupied position")
    void shouldNotAllowMoveToOccupiedPosition() throws Exception {

        Game game = new Game();

        given(gameService.getGame("game-1")).willReturn(game);

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "0"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "1"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "1"))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("should declare player X as winner when top row is filled")
    void shouldDeclareXWinnerForTopRow() throws Exception {
        Game game = new Game();
        given(gameService.getGame("game-1")).willReturn(game);

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "0"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "3"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "1"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "4"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("X_WINS"));

    }

    @Test
    @DisplayName("should declare player X as winner when left column is filled")
    void shouldDeclareXWinnerForLeftColumn() throws Exception {
        Game game = new Game();
        given(gameService.getGame("game-1")).willReturn(game);

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "0"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "1"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "3"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "2"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "6"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("X_WINS"));
    }

    @Test
    @DisplayName("should declare X as winner for diagonal (0,4,8)")
    void shouldDeclareXWinnerForDiagonalLeftToRight() throws Exception {
        Game game = new Game();
        given(gameService.getGame("game-1")).willReturn(game);

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "0"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "1"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "4"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                .param("position", "2"));

        mockMvc.perform(post("/games/{gameId}/moves", "game-1")
                        .param("position", "8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("X_WINS"));

    }
}