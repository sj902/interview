package com.sj0902.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        char ch = board[i][j];
        if (word.charAt(idx) != ch) return false;
        board[i][j] = '#';
        boolean b =
                dfs(board, i + 1, j, word, idx + 1) ||
                        dfs(board, i, j + 1, word, idx + 1) ||
                        dfs(board, i - 1, j, word, idx + 1) ||
                        dfs(board, i, j - 1, word, idx + 1);
        if (b) return true;
        board[i][j] = ch;
        return false;
    }


}
