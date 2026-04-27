package com.mmnkndn.kata.tictactoe.service;

import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame() {
        String gameId = UUID.randomUUID().toString();

        Game game = new Game();
        gameRepository.save(gameId, game);

        return game;
    }

    public Game getGame(String gameId) {
        return gameRepository.findById(gameId);
    }
}