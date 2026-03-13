package com.sj902.graph;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[][] res = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    dfs(visited, board, res, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 'P') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(boolean[][] visited, char[][] board, char[][] res, int nodeI, int nodeJ) {
        visited[nodeI][nodeJ] = true;
        res[nodeI][nodeJ] = 'P';
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int[] dir : dirs) {
            int x = nodeI + dir[0];
            int y = nodeJ + dir[1];

            if (x > 0 && y > 0 && y < n && x < m && !visited[x][y] && board[x][y] == 'O') {
                dfs(visited, board, res, x, y);
            }
        }
    }
}
