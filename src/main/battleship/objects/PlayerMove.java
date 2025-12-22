package main.battleship.objects;

public class PlayerMove {
    Coordinate targetCoordinate;

    public PlayerMove(Coordinate targetCoordinate) {
        this.targetCoordinate = targetCoordinate;
    }

    public Coordinate getTargetCoordinate() {
        return targetCoordinate;
    }
}
