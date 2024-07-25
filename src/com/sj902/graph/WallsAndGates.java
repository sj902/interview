package com.sj902.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};


        islandsAndTreasure(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    public static void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                int x = dir[0];
                int y = dir[1];
                int newRow = row + x;
                int newCol = col + y;

                if(newRow<0 || newCol<0 || newCol>=n || newRow>=m || grid[newRow][newCol]!=INF){
                    continue;
                }
                q.add(new int[]{newRow, newCol});
                grid[newRow][newCol] = grid[row][col] + 1;
            }
        }
    }
}
