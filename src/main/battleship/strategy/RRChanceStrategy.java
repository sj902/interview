package main.battleship.strategy;

public class RRChanceStrategy implements IChanceStrategy {
    int playerCount;

    public RRChanceStrategy(int playerCount) {
        this.playerCount = playerCount;
    }


    @Override
    public int nextMove(int currPlayer) {
        return (1 + currPlayer) % playerCount;
    }

    @Override
    public int firstMove() {
        return 0;
    }
}
