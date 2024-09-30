package com.sj902.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Sol123e {
    public static void main(String[] args) {
        System.out.println(new CountPalindromes().countPalindromes("103301"));
    }
}

public class CountPalindromes {
    HashSet<String> subs;
    Integer[][] dp;

    public int countPalindromes(String s) {
        double mod = (1e9 + 7);
        subs = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    subs.add(("" + i + j + k + j + i));
                }
            }
        }
        int res = 0;
        for (String i : subs) {
            dp = new Integer[s.length()][5];
            int k = (int) (count(s, i, 0, 0) % mod);
            res = (int) ((res + k) % mod);
        }
        return res;
    }

    private int count(String s, String sub, int sIdx, int subIdx) {
        double mod = (1e9 + 7);
        if (subIdx == sub.length()) return 1;
        if (sIdx == s.length()) return 0;
        if(dp[sIdx][subIdx] != null) return dp[sIdx][subIdx];
        int res = 0;
        int k = (int) (count(s, sub, sIdx + 1, subIdx) % mod);
        res = (int) ((res + k) % mod);
        if (s.charAt(sIdx) == sub.charAt(subIdx)) {
            int j = (int) (count(s, sub, sIdx + 1, subIdx + 1) % mod);
            res = (int) ((res + j) % mod);
        }
        return dp[sIdx][subIdx] = (int)(res%mod);
    }
}
