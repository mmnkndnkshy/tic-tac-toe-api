package com.mmnkndn.kata.tictactoe.controller;

import com.mmnkndn.kata.tictactoe.api.GameApi;
import com.mmnkndn.kata.tictactoe.api.dto.GameResponse;
import com.mmnkndn.kata.tictactoe.api.dto.MoveResponse;
import com.mmnkndn.kata.tictactoe.domain.Game;
import com.mmnkndn.kata.tictactoe.domain.GameCreated;
import com.mmnkndn.kata.tictactoe.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class GameController implements GameApi {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @Override
    public ResponseEntity<GameResponse> createGame() {

        GameCreated created = gameService.createGame();

        return ResponseEntity
                .created(URI.create("/games/" + created.gameId()))
                .body(new GameResponse(
                        created.gameId(),
                        created.game().getCurrentPlayer().name()
                ));
    }

    @Override
    public ResponseEntity<MoveResponse> makeMove(String gameId, Integer position) {

        Game game = gameService.getGame(gameId);

        game.makeMove(position);

        Map<String, String> boardDto = game.getBoard()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> String.valueOf(e.getKey()),
                        e -> e.getValue().name()
                ));

        return ResponseEntity.ok(
                new MoveResponse(
                        boardDto,
                        MoveResponse.StatusEnum.fromValue(game.getGameStatus().name())
                )
        );
    }
}