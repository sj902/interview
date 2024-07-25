package com.sj902.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
    int x, y, moves;

    @Override
    public String toString() {
        return "Pos{" +
                "x=" + x +
                ", y=" + y +
                ", moves=" + moves +
                '}';
    }

    public Pos(int x, int y, int moves) {
        this.x = x;
        this.y = y;
        this.moves = moves;
    }
}

public class Wayfair {

    public static void main(String[] args) {
        System.out.println(returnMoves(new int[][]{{0,0,1,0},{0,0,0,0}}, 2));
    }

    static int returnMoves(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        HashSet<String> visited = new HashSet<>();


        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0));
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        visited.add("0-0");
        while (!q.isEmpty()) {
            Pos p = q.poll();
            System.out.println(p);
            int x = p.x;
            int y = p.y;
            int moves = p.moves;

            if (x == m - 1 && y == n - 1) {
                return moves;
            }

            for (int[] dir : dirs) {
                for (int i = 1; i <= k; ++i) {
                    int newX = x + (i * dir[0]);
                    int newY = y + (i * dir[1]);
                    String str = newX + "-" + newY;
                    if (newX >= 0 && newY >= 0 && newY <= n - 1 && newX <= m - 1 && grid[newX][newY]==1){
                        break;
                    }
                    if (!visited.contains(str) && newX >= 0 && newY >= 0 && newY <= n - 1 && newX <= m - 1 && grid[newX][newY]!=1) {
                        visited.add(str);
                        q.add(new Pos(newX, newY, moves + 1));
                    }
                }
            }

        }
        return 0;
    }
}
