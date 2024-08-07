package com.sj902.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    HashSet<String> visited;
    int[][] dirs;

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        visited = new HashSet();
        dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int srcI = -1;
        int srcJ = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    srcI = i;
                    srcJ = j;
                    break;
                }
            }
        }
        grid[srcI][srcJ] = 2;
        dfs(srcI, srcJ, grid);

        int res = 0;

        Queue<String> q = new LinkedList<>(visited);
        while (!q.isEmpty()) {
            int l = q.size();
            System.out.println("size: " + l);
            for (int k = 0; k < l; k++) {
                String a = q.poll();
                System.out.println("q poll: " + a);
                int i = Integer.parseInt(a.split("-")[0]);
                int j = Integer.parseInt(a.split("-")[1]);
                if (grid[i][j] == 1) {
                    return res-1;
                }
                for (int[] dir : dirs) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    String z = newI + "-" + newJ;

                    if (newJ >= 0 && newI >= 0 && newI < grid.length && newJ < grid.length && !visited.contains(z)) {
                        q.add(z);
                        visited.add(z);
                    }
                }

            }
            res = res + 1;
        }
        return -1;

    }

    private void dfs(int i, int j, int[][] grid) {
        visited.add(i + "-" + j);
        grid[i][j] = 2;
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newJ >= 0 && newI >= 0 && newI < grid.length && newJ < grid.length && grid[newI][newJ] == 1) {
                System.out.println("dfs:: for::" + newI + "-" + newJ);
                dfs(newI, newJ, grid);
            }
        }
    }
}
