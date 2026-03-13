package com.sj902.graph;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    res[i][j] = 0;
                } else if (grid[i][j] == 1) {
                    res[i][j] = Integer.MAX_VALUE;
                } else {
                    res[i][j] = -1;
                }
            }
        }

        int ans = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = row + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || res[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[]{x, y});
                res[x][y] = 1 + res[row][col];
                ans = Math.max(ans, res[row][col]);
            }

        }

        System.out.println(Arrays.deepToString(res));
        return ans;
    }
}
