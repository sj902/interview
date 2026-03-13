package com.sj902.graph;

// 0 -> not sure
// 1 -> Guard
// 2 -> Wall
// 3 -> Guard

import java.util.LinkedList;
import java.util.Queue;

public class CountUnguarded {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] matrix = new int[m][n];
        for (int[] a : walls) {
            matrix[a[0]][a[1]] = 2;
        }
        for (int[] a : guards) {
            matrix[a[0]][a[1]] = 1;
            int row = a[0];
            int col = a[1];
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                while (newRow < m && newRow >= 0 && newCol < n && newCol >= 0 &&
                        matrix[newRow][newCol] == 0) {
                    matrix[newRow][newCol] = 3;
                    newRow = newRow + dir[0];
                    newCol = newCol + dir[1];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]+"\t");
                if (matrix[i][j] == 0) ++res;
            }
        }
        return res;
    }
}
