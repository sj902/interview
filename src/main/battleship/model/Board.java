package main.battleship.model;

import main.battleship.objects.Coordinate;
import main.battleship.objects.IBoundary;

import java.util.ArrayList;
import java.util.List;

public class Board {
    IBoundary boundary;
    IBoardItem ship;
    List<Coordinate> hitCoordinates;

    public int getRemShipCount() {
        return remShipCount;
    }

    int remShipCount;

    public Board(IBoundary boundary, IBoardItem ship) throws Exception {
        this.boundary = boundary;
        this.ship = ship;
        this.hitCoordinates = new ArrayList<>();
        remShipCount = 1;

        for (Coordinate i: ship.getCoordinates()) {
            if(!boundary.contains(i)){
                throw new Exception("Ship should be in user boundary");
            }
        }
    }

    String takeHit(Coordinate coordinate) {
        hitCoordinates.add(coordinate);
        if (ship.contains(coordinate)) {
            remShipCount = 0;
            return "\"Hit\"" + " " + ship.getName() + " destroyed";
        }
        return "\"Miss\"";
    }

    public IBoundary getBoundary() {
        return boundary;
    }

    public IBoardItem getShip() {
        return ship;
    }

    public List<Coordinate> getHitCoordinates() {
        return hitCoordinates;
    }
}


/*
PlayerA’s turn: Missile fired at (3, 0) : “Miss” : Ships
Remaining - PlayerA:1, PlayerB:1
PlayerB’s turn: Missile fired at (1, 1) : “Miss” : Ships
Remaining - PlayerA:1, PlayerB:1
PlayerA’s turn: Missile fired at (5, 3) : “Hit” B-SH2 destroyed
: Ships Remaining - PlayerA:1, PlayerB:0
GameOver. PlayerA wins.
* */