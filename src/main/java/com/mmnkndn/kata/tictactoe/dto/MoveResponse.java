package com.mmnkndn.kata.tictactoe.dto;
import com.mmnkndn.kata.tictactoe.domain.Player;

import java.util.Map;

public record MoveResponse(Map<Integer, Player> board) {
}
