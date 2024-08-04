package com.sj902.graph;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        int sc = -1;
        int sr = -1;

        for(int i = 0; i< m; ++i){
            for (int j = 0; j <n ; j++) {
                if(grid[i][j]!=0) {
                    sr = i;
                    sc = j;
                }
            }
        }

        if(sr==-1) return 0;

        return dfs(grid, visited, dirs, sr, sc);
    }

    private int dfs(int[][] grid, boolean[][] visited, int[][] dirs, int sr, int sc) {
        visited[sr][sc] = true;
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int[] dir: dirs) {
            int x = sr+dir[0];
            int y = sc+dir[1];
            if(x>=0 && y>=0 && x<m && y<n && !visited[x][y] && grid[x][y]==1){
                result = result + dfs(grid, visited, dirs, x, y);
            }
        }

        int borders = 0;

        for (int[] dir: dirs) {
            int x = sr+dir[0];
            int y = sc+dir[1];
            if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                ++ borders;
            }
        }

        return 4-borders+result;
    }
}
