package com.sj902.graph;

import java.util.ArrayList;
public class CourseSchedule {

    boolean[] recStack;
    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;

    public boolean canFinish(int n, int[][] prerequisites) {
        recStack = new boolean[n];
        adj = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!dfs(i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int i) {
        visited[i] = true;
        recStack[i] = true;
        for (int n:adj.get(i)) {
            if(recStack[n]){
                return false;
            }
            if(!visited[n] && !dfs(n))
                return false;
        }
        recStack[i] = false;
        return true;
    }
}
