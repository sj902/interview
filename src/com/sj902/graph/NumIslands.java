package com.sj902.graph;

public class NumIslands {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '0', '0', '1'}, {'1', '1', '0', '0', '1'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                System.out.println(i+"-"+j+"-"+visited[i][j]);
                if (!visited[i][j] && grid[i][j]=='1') {
                    dfs(visited, grid, i, j);
                    ++res;
                }
            }

        }
        return res;

    }

    private static void dfs(boolean[][] visited, char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        int[] a = new int[]{i + 1, j};
        int[] b = new int[]{i - 1, j};
        int[] c = new int[]{i, j + 1};
        int[] d = new int[]{i, j - 1};
        if (a[0] < m && a[1] < n && a[0] >= 0 && a[1] >= 0 && !visited[a[0]][a[1]] && grid[a[0]][a[1]]=='1') {
            dfs(visited, grid, a[0], a[1]);
        }
        if (b[0] < m && b[1] < n && b[0] >= 0 && b[1] >= 0 && !visited[b[0]][b[1]] && grid[b[0]][b[1]]=='1') {
            dfs(visited, grid, b[0], b[1]);
        }
        if (c[0] < m && c[1] < n && c[0] >= 0 && c[1] >= 0 && !visited[c[0]][c[1]] && grid[c[0]][c[1]]=='1') {
            dfs(visited, grid, c[0], c[1]);
        }
        if (d[0] < m && d[1] < n && d[0] >= 0 && d[1] >= 0 && !visited[d[0]][d[1]] && grid[d[0]][d[1]]=='1') {
            dfs(visited, grid, d[0], d[1]);
        }

    }
}
