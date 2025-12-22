package main.battleship.model;

import main.battleship.objects.Coordinate;

import java.util.List;

public interface IBoardItem {
    List<Coordinate> getCoordinates();
    String getName();
    boolean contains(Coordinate coordinate);
}
