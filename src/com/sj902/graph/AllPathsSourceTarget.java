package com.sj902.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    List<List<Integer>> res;
    int[][] grid;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        grid = graph;
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int i, ArrayList<Integer> curr) {
        if(i == grid.length-1) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = 0; j < grid[i].length; j++) {
            curr.add(grid[i][j]);
            dfs(grid[i][j], curr);
        }
    }
}
