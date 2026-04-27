package com.mmnkndn.kata.tictactoe.controller;

import com.mmnkndn.kata.tictactoe.dto.GameResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public GameResponse createGame(){
        return new GameResponse("X");
    }
}
