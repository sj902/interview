package com.sj0902.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class P1235 {
    int i;
    int j;

    public P1235(int m, int n) {
        this.i = m;
        this.j = n;
    }
}

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<P1235> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new P1235(i, j));
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int time = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            boolean freshRotted = false;
            for (int i = 0; i < len; i++) {
                P1235 p = q.poll();
                for (int[] dir : dirs) {
                    int nI = p.i + dir[0];
                    int nJ = p.j + dir[1];
                    if (nI >= 0 && nI < m && nJ >= 0 && nJ < n && grid[nI][nJ] == 1) {
                        grid[nI][nJ] = 2;
                        freshRotted = true;
                        q.add(new P1235(nI, nJ));
                    }
                }
            }
           if(freshRotted) {
               ++time;
           }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;


    }
}