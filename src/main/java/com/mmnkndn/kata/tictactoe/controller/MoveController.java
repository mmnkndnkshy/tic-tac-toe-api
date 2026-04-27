package com.mmnkndn.kata.tictactoe.controller;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.domain.Player;
import com.mmnkndn.kata.tictactoe.dto.MoveResponse;
import com.mmnkndn.kata.tictactoe.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class MoveController {

    private final GameService gameService;

    MoveController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/games/{gameId}/moves")
    ResponseEntity<MoveResponse> makeMove(@PathVariable String gameId,
                                          @RequestParam int position) {

        Game game = gameService.getGame(gameId);

        game.makeMove(position, Player.X);

        return ResponseEntity.ok(new MoveResponse(game.getBoard()));
    }
}