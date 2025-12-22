package main.battleship.strategy;

public interface IChanceStrategy {
    int nextMove(int currPlayer);
    int firstMove();
}
