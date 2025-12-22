package main.battleship.model;

import main.battleship.objects.Coordinate;

import java.util.List;

public class Ship implements IBoardItem{
    String name;
    List<Coordinate> coordinates;

    public Ship(String name, List<Coordinate> coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean contains(Coordinate coordinate) {
        for(Coordinate c: coordinates){
            if(c.getX() == coordinate.getX() && c.getY() == coordinate.getY()){
                return true;
            }
        }
        return false;
    }
}
