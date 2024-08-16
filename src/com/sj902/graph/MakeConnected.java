package com.sj902.graph;

import java.util.ArrayList;

public class MakeConnected {
    boolean[] visited;
    ArrayList<ArrayList<Integer>> adj;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        visited = new boolean[n];

        adj = new ArrayList<>();
        int comp = 0;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(i);
                ++comp;
            }
        }
        return comp-1;
    }

    private void dfs(int i) {
        visited[i] = true;
        for (int n: adj.get(i)) {
            if(!visited[n]){
                dfs(n);
            }
        }
    }
}
