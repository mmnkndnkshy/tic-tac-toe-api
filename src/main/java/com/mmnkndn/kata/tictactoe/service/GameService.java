package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;

public interface GameService {
    Game createGame();
    Game getGame(String gameId);
}