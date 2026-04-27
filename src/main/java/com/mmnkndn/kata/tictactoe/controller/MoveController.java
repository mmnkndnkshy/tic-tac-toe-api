package com.mmnkndn.kata.tictactoe.controller;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/games")
class MoveController {

    private final GameService gameService;

    MoveController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/{gameId}/moves")
    ResponseEntity<?> makeMove(@PathVariable String gameId,
                               @RequestParam int position) {

        Game game = gameService.getGame(gameId);

        game.makeMove(position);

        return ResponseEntity.ok(Map.of("board", game.getBoard() ,"status", game.getGameStatus()));
    }

}