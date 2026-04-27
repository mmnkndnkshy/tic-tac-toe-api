package com.mmnkndn.kata.tictactoe.controller;

import com.mmnkndn.kata.tictactoe.dto.GameResponse;
import com.mmnkndn.kata.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {


    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public GameResponse createGame(){
        return new GameResponse(gameService.createGame().getCurrentPlayer().name());
    }
}
