package com.sj902.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int i = c[0];
            int j = c[1];
            int dist = c[2];
            mat[i][j] = dist;
            for (int[] dir : dirs) {
                int newR = i + dir[0];
                int newC = j + dir[1];
                if (newR >= 0 && newC >= 0 && newR < mat.length && newC < mat[0].length && !visited[newR][newC]) {
                    q.add(new int[]{newR, newC, dist});
                    visited[newR][newC] = true;
                }
            }
        }
        return mat;
    }
}
