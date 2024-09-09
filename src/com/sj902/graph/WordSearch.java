package com.sj902.graph;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (word.length() == 0) return true;
        int m = board.length;
        int n = board[0].length;
        if (word.length() > m * n) return false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean k = dfs(board, word, i, j, 0);
                if (k) return k;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(idx) != board[i][j]) return false;
        if (word.length() - 1 == idx) return true;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            boolean k = dfs(board, word, newI, newJ, idx + 1);
            if (k) return true;

        }
        board[i][j] = word.charAt(idx);
        return false;
    }
}
