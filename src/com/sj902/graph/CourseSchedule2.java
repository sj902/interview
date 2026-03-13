package com.sj902.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {
    List<List<Integer>> adj;
    Stack<Integer> stack;
    boolean[] visited;
    boolean[] recStack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        stack = new Stack<>();
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(i)) return new int[]{};
            }
        }
        int q = 0;
        while (!stack.isEmpty()) {
            res[q++] = stack.pop();
        }
        return res;
    }

    private boolean dfs(int i) {
        visited[i] = true;
        recStack[i] = true;
        for(int node: adj.get(i)){
            if(recStack[node]) return false;
            if(!visited[node]){
                boolean k = dfs(node);
                if(!k) return false;
            }
        }
        recStack[i] = false;
        stack.push(i);
        return true;
    }
}
