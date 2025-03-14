package com.sj0902.dp;

public class KnightProbability {
    int size;
    Double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {
        size = n;
        dp = new Double[k + 1][n + 1][n + 1];
        return aux(k, row, column);
    }

    private double aux(int k, int row, int column) {
        if (row < 0 || column < 0 || row > size - 1 || column > size - 1) return 0;
        if (k == 0) return 1;
        if (dp[k][row][column] != null) return dp[k][row][column];
        double next =
                aux(k - 1, row - 2, column - 1) +
                        aux(k - 1, row - 2, column + 1) +
                        aux(k - 1, row - 1, column + 2) +
                        aux(k - 1, row - 1, column - 2) +
                        aux(k - 1, row + 1, column - 2) +
                        aux(k - 1, row + 1, column + 2) +
                        aux(k - 1, row + 2, column + 1) +
                        aux(k - 1, row + 2, column - 1);
        return dp[k][row][column] = next / 8;
    }
}
