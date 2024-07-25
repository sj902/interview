package com.sj902.graph;

import java.util.*;

public class PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> p = bfs(heights, 0);
        Set<String> q = bfs(heights, 1);
        Set<String> r = new HashSet<>(p);
        r.addAll(q);


        List<List<Integer>> res = new ArrayList<>();

        for(String s: r){
            if(p.contains(s) && q.contains(s)){
                String[] spl = s.split("-");
                int a = Integer.parseInt(spl[0]);
                int b = Integer.parseInt(spl[1]);
                List<Integer> l = new ArrayList<Integer>();
                l.add(a);
                l.add(b);
                res.add(l);
            }
        }
        return res;
    }

    private Set<String> bfs(int[][] grid, int sea) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((sea == 0 && (i == 0 || j == 0)) || (sea == 1 && (i == m - 1 || j == n - 1))) {
                    q.add(new int[]{i, j});
                    set.add(i + "-" + j);
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            visited.add(row+"-"+col);

            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];

                int nodeVal = grid[row][col];

                if (x < 0 || y < 0 || x >= m || y >= m || visited.contains(x+"-"+y) || grid[x][y] < nodeVal) {
                    continue;
                }

                q.add(new int[]{x, y});
                set.add(x + "-" + y);
            }
        }
        return set;
    }
}
