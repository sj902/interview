package com.sj902.graph;

import java.util.Arrays;

public class FloydWarshall {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, 10001);
        }

        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }

        for (int i = 0; i < n; ++i) {
            dist[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

        int res = 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(dist[i][j]<=distanceThreshold){
                    ++count;
                }
            }
            System.out.println(i+":"+count);
            if(count<min){
                min = count;
                res = i;
            }
        }
        return res;
    }
}
