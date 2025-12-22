package main.battleship.strategy;

import java.util.List;
import java.util.Random;

import main.battleship.objects.Coordinate;
import main.battleship.objects.PlayerMove;

public class RandomMoveStrategy implements IMoveStrategy{
    @Override
    public PlayerMove getMove(List<Coordinate> coordinateList) {
        int random = new Random().nextInt(coordinateList.size());
        return new PlayerMove(coordinateList.get(random));
    }
}
