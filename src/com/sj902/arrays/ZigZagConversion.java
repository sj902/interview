package com.sj902.arrays;

import java.util.Arrays;

public class ZigZagConversion {
    public String convert(String s, int n) {
        if (n == 1) return s;
        char[][] dp = new char[n][s.length()];
        int magic = 2 * (n - 1);
        for (int i = 0; i < s.length(); i++) {
            int col = i / (2 * (n - 1));
            int row = i % magic;

            System.out.println(i + ":" + row + ":" + col);
            if (row >= n) {
                col = (col * (n - 1)) + row - n + 1;
                row = magic - row;

            } else {
                col = col * (n - 1);
            }
            System.out.println(i + ":" + row + ":" + col);
            dp[row][col] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (Character.isAlphabetic(dp[i][j]) || dp[i][j] == '.' || dp[i][j] == ',')
                    sb.append(dp[i][j]);
            }
        }
        return sb.toString();
    }
}
