package main.battleship.objects;

import java.util.List;

public interface IBoundary {
    List<Coordinate> getAllCoordinates();
    boolean contains(Coordinate coordinate);
}
