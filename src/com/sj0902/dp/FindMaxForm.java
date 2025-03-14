package com.sj0902.dp;

import java.util.HashMap;

public class FindMaxForm {
    HashMap<Integer, Integer> zero;
    HashMap<Integer, Integer> one;
    String[] str;
    Integer dp[][][];

    public int findMaxForm(String[] strs, int m, int n) {
        zero = new HashMap<>();
        one = new HashMap<>();
        str = strs;
        dp = new Integer[strs.length + 1][m + 1][n + 1];
        for (int j = 0; j < strs.length; j++) {
            String s = strs[j];
            zero.put(j, 0);
            one.put(j, 0);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zero.put(j, zero.get(j) + 1);
                if (s.charAt(i) == '1') one.put(j, one.get(j) + 1);
            }
        }

        return aux(0, m, n);
    }

    private int aux(int idx, int z, int o) {
        if (idx >= str.length) return 0;
        if (dp[idx][z][o] != null) return dp[idx][z][o];
        if (zero.get(idx) > z || one.get(idx) > o) return dp[idx][z][o] = aux(idx + 1, z, o);
        return dp[idx][z][o] = Math.max(1 + aux(idx + 1, z - zero.get(idx), o - one.get(idx)),
                aux(idx + 1, z, o));
    }

}
