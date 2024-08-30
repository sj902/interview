package com.sj902.graph;

import java.util.*;

public class RemoveStones {
    public int removeStones(int[][] stones) {

        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();

        Arrays.sort(stones, (a, b) -> {
            if (Integer.compare(a[0], b[0]) == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            Set<Integer> rowSet = rows.getOrDefault(row, new HashSet<>());
            rowSet.add(i);
            rows.put(row, rowSet);

            int col = stones[i][1];
            Set<Integer> colSet = cols.getOrDefault(col, new HashSet<>());
            colSet.add(i);
            cols.put(col, colSet);
        }

        boolean[] visited = new boolean[stones.length];
        int res = 0;

        for (int i = 0; i < stones.length; i++) {
            if(!visited[i]){
               res = Math.max(dfs(i, stones, visited, rows, cols),res);
            }
        }
        return res;
    }

    private int dfs(int idx, int[][] stones, boolean[] visited, Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> cols) {
        visited[idx] = true;
        int row = stones[idx][0];
        int col = stones[idx][1];
        int res = 1;
        HashSet<Integer> indeces = new HashSet<>();
        indeces.addAll(rows.get(row));
        indeces.addAll(rows.get(col));
        for(int i: indeces){
            if(!visited[i]){
                res += dfs(i, stones, visited, rows, cols);
            }
        }
        return res;
    }
}
