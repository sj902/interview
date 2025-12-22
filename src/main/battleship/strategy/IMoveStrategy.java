package main.battleship.strategy;

import main.battleship.objects.Coordinate;
import main.battleship.objects.PlayerMove;

import java.util.List;

public interface IMoveStrategy {
    PlayerMove getMove(List<Coordinate> coordinateList);
}
