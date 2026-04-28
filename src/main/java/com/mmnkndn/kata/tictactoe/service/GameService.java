package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.domain.GameCreated;

public interface GameService {


    GameCreated createGame();

    Game getGame(String gameId);

    Game makeMove(String gameId, int position);
}