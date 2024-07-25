package com.sj902.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CourseSchedule2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
    }

    public static int[] findOrder(int n, int[][] prerequisites) {
        int[] res = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                boolean k = dfs(visited, recStack, stack, adj, i);
                if (k) return new int[]{};
            }
        }

        int u = 0;

        while (!stack.isEmpty()) {
            res[u] = stack.pop();
            u++;
        }
        return res;

    }

    private static boolean dfs(boolean[] visited, boolean[] recStack, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, int n) {
        visited[n] = true;
        recStack[n] = true;

        for (int node : adj.get(n)) {
            if (recStack[node]) {
                return true;
            }
            if (!visited[node] && dfs(visited, recStack, stack, adj, node)) {
                return true;
            }
        }

        stack.push(n);
        recStack[n] = false;
        return false;
    }
}
