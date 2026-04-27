package com.mmnkndn.kata.tictactoe.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should create a new game and return the current player as X")
    void shouldCreateNewGameAndReturnCurrentPlayerAsX() throws Exception {
        mockMvc.perform(post("/game"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.currentPlayer").value("X"));
    }
}
