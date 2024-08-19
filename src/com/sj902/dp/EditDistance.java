package com.sj902.dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] res = new int[m+1][n+1];
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++){
                if(i == 0 || j == 0) {
                    res[i][j] = 0;
                } else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    res[i][j] = res[i-1][j-1];
                } else {
                    res[i][j] = 1+ Math.min(res[i-1][j-1], Math.min(res[i][j-1], res[i-1][j]));
                }
            }
        }
        return res[m][n];
    }
}
