package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Override
    public Game createGame() {
        return new Game();
    }
}