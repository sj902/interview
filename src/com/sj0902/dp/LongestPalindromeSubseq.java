package com.sj0902.dp;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = t.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][n];
    }
}
