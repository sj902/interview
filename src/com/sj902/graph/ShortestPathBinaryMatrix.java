package com.sj902.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = -1;
        int res = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] p = q.poll();
                if (p[0] == n - 1 && p[1] == n - 1) return res;
                for (int[] dir : dirs) {
                    int newI = p[0] + dir[0];
                    int newJ = p[1] + dir[1];
                    if (newI >= 0 && newJ >= 0 && newJ < n && newI < n && grid[newI][newJ] == 0) {
                        q.add(new int[]{newI, newJ});
                        grid[newI][newJ] = -1;
                    }
                }
                ++res;
            }
        }
        return -1;
    }
}
