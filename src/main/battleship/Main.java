package main.battleship;

/*
Mandatory:
● initGame(N)

This will initialize the game with a battlefield of size NxN. Where the left half of
N/2xN will be assigned to PlayerA and the right half will be assigned to PlayerB

● addShip(id, size, x position PlayerA, y position PlayerA, x position PlayerB, y position
PlayerB)
This will add a ship of given size at the given coordinates in both the player’s
fleet.

● startGame()

This will begin the game, where PlayerA will always take the first turn. The output
of each step should be printed clearly in the console.
For eg.
PlayerA’s turn: Missile fired at (2, 4). “Hit”. PlayerB’s ship with id “SH1”
destroyed.
PlayerB’s turn: Missile fired at (6, 1). “Miss”

Optional
● viewBattleField()

This will display the battlefield as a NxN grid and all the ships along with the grids
occupied by each ship. PlayerA’s ship with id SH1 will be marked as A-SH1, with
id SH2 as A-SH2 and so on. Whereas PlayerB’s ships will be marked as B-SH1,
B-SH2 and so on.
Note: It should mark all the grids occupied by a ship and not just the center
coordinate.


*
* */


public class Main {
    static void main(String[] args) throws Exception {
        System.out.println("test");

        GameLoop gl = new GameLoop();
        gl.init(6);
        gl.addShip("SH1", 2, 1, 5, 4, 4);
        gl.startGame();

    }
}








