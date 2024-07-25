package com.sj902.dp;

import java.util.Arrays;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(Arrays.deepToString(res));
    }

    static int[][] res;

    public static int countSubstrings(String s) {
        res = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < s.length(); j++) {
                res[i][j] = -1;
                if (i == j) {
                    res[i][j] = 1;
                }
            }
        }
        int count = 0;
        countSubstringsAux(s, 0, s.length() - 1);
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); j++) {
                if (res[i][j] == 1) {
                    ++count;
                }
            }
        }
        return count;
    }

    private static boolean countSubstringsAux(String s, int i, int j) {
        if (i == j) return true;
        if (i < 0 || j < 0 || i >= s.length() || j >= s.length()) return true;
        if (res[i][j] == 0) return false;
        if (res[i][j] == 1) return true;

        if (s.charAt(i) == s.charAt(j)) {
            System.out.println(s.charAt(i) + "\t" + s.charAt(j) + "\t" + i + "\t" + j + "\t" + s.substring(i, j + 1));
            boolean r = countSubstringsAux(s, i + 1, j - 1);
            if (r) {
                System.out.println(s.charAt(i) + "\t" + s.charAt(j) + "\t" + i + "\t" + j + "\t" + s.substring(i, j + 1) + "\t" + r);
                res[i][j] = 1;
                return true;
            } else {
                res[i][j] = 0;
                return false;
            }
        }
        res[i][j] = 0;
        return false;
    }

}