package com.mmnkndn.kata.tictactoe.repository;

import com.mmnkndn.kata.tictactoe.domain.Game;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class GameRepository {

    private final Map<String, Game> store = new ConcurrentHashMap<>();

    public void save(String gameId, Game game) {
        store.put(gameId, game);
    }

    public Game findById(String gameId) {
        return store.get(gameId);
    }
}