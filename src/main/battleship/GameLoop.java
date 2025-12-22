package main.battleship;

import main.battleship.model.Board;
import main.battleship.model.IBoardItem;
import main.battleship.model.Player;
import main.battleship.model.Ship;
import main.battleship.objects.Coordinate;
import main.battleship.objects.PlayerMove;
import main.battleship.objects.RectangularBoundary;
import main.battleship.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class GameLoop {

    List<Player> players;
    IWinnerStrategy iwds;
    IChanceStrategy ics;
    int size;


    void init(int N) {
        iwds = new SimpleWinnerStrategy();
        size = N;
    }


    void addShip(String id, int size, int xA, int yA, int xB, int yB) throws Exception {
        IMoveStrategy ims = new RandomMoveStrategy();
        ics = new RRChanceStrategy(2);

        IBoardItem ship1 = new Ship("A" + id, calCoordinates(size, xA, yA));
        IBoardItem ship2 = new Ship("B" + id, calCoordinates(size, xB, yB));

        Board b1 = new Board(new RectangularBoundary(new Coordinate(0, 0), this.size / 2, this.size), ship1);


        Board b2 = new Board(new RectangularBoundary(new Coordinate(this.size / 2, 0), this.size / 2, this.size), ship2);

        Player p1 = new Player("PlayerA", b1, ims);
        Player p2 = new Player("PlayerB", b2, ims);

        players = new ArrayList<>();
        players.add(p1);
        players.add(p2);

    }

    private List<Coordinate> calCoordinates(int size, int xA, int yA) {
        List<Coordinate> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res.add(new Coordinate(i + xA, j + yA));
            }
        }
        return res;
    }

    void startGame() {
        int currentPlayer = ics.firstMove();
        while (true) {
            Player curr = players.get(currentPlayer);
            PlayerMove pv = curr.move(players.get((1 + currentPlayer) % players.size()).getAllCoorinates());
            String hitOP = players.get((1 + currentPlayer) % players.size()).takeHit(pv.getTargetCoordinate());

            String op = curr.getName() + " turn: Missile fired at (" + pv.getTargetCoordinate().getX() + ", " +
                    pv.getTargetCoordinate().getY() + "): " + hitOP + " : Ships\n" +
                    "            Remaining - " + players.get(0).getName() + ": " + players.get(0).getRemainingShipCount() +
                    players.get(1).getName() + ": " + players.get(1).getRemainingShipCount();
            System.out.println(op);
            if (iwds.getWinner(players) != null) {
                System.out.println("GameOver. " + iwds.getWinner(players).getName() + " wins.");
                break;
            }
            currentPlayer = ics.nextMove(currentPlayer);
        }
    }
}
