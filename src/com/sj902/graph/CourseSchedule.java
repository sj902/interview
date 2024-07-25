package com.sj902.graph;

import java.util.ArrayList;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < prerequisites.length; ++i) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(a).add(b);
        }

        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                if (dfs(adj, visited, recStack, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack, int node) {
        visited[node] = true;
        recStack[node] = true;

        for (int n : adj.get(node)) {
            if (!visited[n]) {
                if (dfs(adj, visited, recStack, n)) {
                    return true;
                }
            }
            if (recStack[n]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }
}
