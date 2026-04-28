package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.domain.GameCreated;
import com.mmnkndn.kata.tictactoe.exception.GameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final Map<String, Game> games = new HashMap<>();


    @Override
    public GameCreated createGame() {
        String gameId = UUID.randomUUID().toString();
        Game game = new Game();
        games.put(gameId, game);
        return new GameCreated(gameId, game);
    }

    @Override
    public Game getGame(String gameId) {
        Game game = games.get(gameId);

        if (game == null) {
            throw new GameNotFoundException(gameId);
        }

        return game;
    }

    @Override
    public Game makeMove(String gameId, int position) {
        Game game = getGame(gameId);
        game.makeMove(position);
        return game;
    }
}