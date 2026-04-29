package com.mmnkndn.kata.tictactoe.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameFactory {

    private final MoveValidator moveValidator;
    private final GameStatusEvaluator gameStatusEvaluator;

    public Game create() {
        return new Game(moveValidator, gameStatusEvaluator);
    }
}