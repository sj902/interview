package com.sj0902.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {
    HashMap<Integer, HashSet<Integer>> adj;
    boolean[] visited;
    boolean[] recStack;

    public boolean canFinish(int n, int[][] prerequisites) {
        visited = new boolean[n];
        recStack = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.put(i, new HashSet<>());
        }
        for (int[] e : prerequisites) {
            adj.get(e[0]).add(e[1]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean d = dfs(i);
                if (!d) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i) {
        visited[i] = true;
        recStack[i] = true;
        HashSet<Integer> neighbours = adj.get(i);
        for (int j : neighbours) {
            if (recStack[j]) return false;
            if (!visited[j] && dfs(j)) {
                return false;
            }
        }
        recStack[i] = false;
        return true;
    }
}
