package com.sj0902.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class CourseSchedule2 {
    HashMap<Integer, HashSet<Integer>> adj;
    boolean[] visited;
    boolean[] recStack;
    Stack<Integer> stack;

    public int[] findOrder(int n, int[][] prerequisites) {
        visited = new boolean[n];
        recStack = new boolean[n];
        stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new HashSet<>());
        }
        for (int[] e : prerequisites) {
            adj.get(e[1]).add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean d = dfs(i);
                if (!d) {
                    return new int[]{};
                }
            }
        }
        int q = 0;
        int[] res = new int[n];
        while (!stack.isEmpty()) {
            res[q++] = stack.pop();
        }
        return res;
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
        stack.push(i);
        return true;
    }
}
