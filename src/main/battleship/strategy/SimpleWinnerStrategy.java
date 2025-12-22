package main.battleship.strategy;

import main.battleship.model.Player;

import java.util.ArrayList;
import java.util.List;

public class SimpleWinnerStrategy implements  IWinnerStrategy{
    @Override
    public Player getWinner(List<Player> players) {
        List<Player> remainingPlayers = new ArrayList<>();


        for(Player p: players){
            if(!p.allShipsDestroyed()){
                remainingPlayers.add(p);
            }
        }
        if(remainingPlayers.size() == 1){
            return remainingPlayers.get(0);
        }
        return null;
    }
}
