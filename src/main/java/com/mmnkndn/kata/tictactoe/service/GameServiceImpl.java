package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.domain.GameFactory;
import com.mmnkndn.kata.tictactoe.domain.GameSession;
import com.mmnkndn.kata.tictactoe.exception.GameErrorCode;
import com.mmnkndn.kata.tictactoe.exception.GameException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service

public class GameServiceImpl implements GameService {

    private final Map<String, Game> games = new HashMap<>();
    private final GameFactory gameFactory;

    public GameServiceImpl(GameFactory gameFactory) {
        this.gameFactory = gameFactory;
    }

    @Override
    public GameSession createGame() {
        String gameId = UUID.randomUUID().toString();

        Game game = gameFactory.create();

        games.put(gameId, game);
        return new GameSession(gameId, game);
    }

    @Override
    public Game getGame(String gameId) {
        Game game = games.get(gameId);

        if (game == null) {
            throw new GameException(GameErrorCode.GAME_NOT_FOUND, gameId);
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