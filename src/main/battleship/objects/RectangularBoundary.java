package main.battleship.objects;

import java.util.ArrayList;
import java.util.List;

public class RectangularBoundary implements IBoundary {

    List<Coordinate> coordinates;

    public RectangularBoundary(Coordinate bottomLeft, int width, int height) {
        coordinates = new ArrayList<>();
        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= height; j++) {
                coordinates.add(new Coordinate(bottomLeft.x + i, bottomLeft.y + j));
            }
        }
    }

    @Override
    public List<Coordinate> getAllCoordinates() {
        return coordinates;
    }

    @Override
    public boolean contains(Coordinate coordinate) {

        for(Coordinate c: coordinates){
            System.out.println(c);
        }


        for (Coordinate c : coordinates) {
            if (c.x == coordinate.x && c.y == coordinate.y) {
                return true;
            }
        }
        return false;
    }
}
