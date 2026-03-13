package com.sj0902.dp;

public class MinimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        return aux(s1, s2, 0, 0);
    }

    private int aux(String s1, String s2, int i, int j) {
        if (i == s1.length() && j == s2.length()) return 0;
        if (i == s1.length()) {
            return calc(s2, j);
        }
        if (j == s2.length()) {
            return calc(s1, i);
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return Math.min(aux(s1, s2, i + 1, j + 1),
                    Math.min(aux(s1, s2, i + 1, j) + (int) (s1.charAt(i)),
                            aux(s1, s2, i + 1, j + 1) + (int) (s2.charAt(j))));
        } else {
            return Math.min(aux(s1, s2, i + 1, j) + (int) (s1.charAt(i)),
                    aux(s1, s2, i , j + 1) + (int) (s2.charAt(j)));
        }
    }

    private int calc(String s2, int j) {
        int res = 0;
        for (int i = j; i < s2.length(); i++) {
            res += (int) (s2.charAt(i));
        }
        return res;
    }
}
