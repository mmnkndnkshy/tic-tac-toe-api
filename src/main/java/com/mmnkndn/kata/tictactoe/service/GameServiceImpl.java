package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final Map<String, Game> games = new HashMap<>();

    @Override
    public Game createGame() {
        String gameId = UUID.randomUUID().toString();
        Game game = new Game();
        games.put(gameId, game);
        return game;
    }

    @Override
    public Game getGame(String gameId) {
        return games.get(gameId);
    }

    @Override
    public Game makeMove(String gameId, int position) {
        Game game = getGame(gameId);
        game.makeMove(position);
        return game;
    }
}