package main.battleship.model;

import main.battleship.objects.Coordinate;
import main.battleship.objects.PlayerMove;
import main.battleship.strategy.IMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public Player(String name, Board board, IMoveStrategy moveStrategy) {
        this.name = name;
        this.board = board;
        this.moveStrategy = moveStrategy;
        this.opponentHitLocations = new ArrayList<>();
    }

    String name;
    Board board;
    IMoveStrategy moveStrategy;
    List<Coordinate> opponentHitLocations;

    public boolean allShipsDestroyed() {
        return board.remShipCount == 0;
    }

    public PlayerMove move(List<Coordinate> coordinates) {
        PlayerMove mv = moveStrategy.getMove(coordinates);
        if (haveHit(mv.getTargetCoordinate())) {
            this.move(coordinates);
        }
        return mv;
    }

    private boolean haveHit(Coordinate targetCoordinate) {
        for (Coordinate location : opponentHitLocations) {
            if (location.getX() == targetCoordinate.getX() && location.getY() == targetCoordinate.getY()) {
                return false;
            }
        }
        return true;
    }

    public String takeHit(Coordinate coordinate) {
        return board.takeHit(coordinate);
    }

    public String getName() {
        return name;
    }

    public int getRemainingShipCount() {
        return board.remShipCount;
    }

    public List<Coordinate> getAllCoorinates() {
        return board.getBoundary().getAllCoordinates();
    }
}
