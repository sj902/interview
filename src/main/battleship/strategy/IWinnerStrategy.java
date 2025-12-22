package main.battleship.strategy;

import main.battleship.model.Player;

import java.util.List;

public interface IWinnerStrategy {
    Player getWinner(List<Player> players);
}
