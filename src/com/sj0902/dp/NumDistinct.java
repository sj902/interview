package com.sj0902.dp;

import java.util.Arrays;

public class NumDistinct {
    String a, b;
    int m, n;

    public int numDistinct(String s, String t) {
        a = s;
        b = t;
        m = s.length();
        n = t.length();
        return aux(0,0);
    }

    private int aux(int i, int j) {
        if(j == n) return 1;
        if(i == m) return 0;
        if(a.charAt(i) == b.charAt(j)){
            return aux(i+1, j+1) + aux(i+1, j);
        }
        return aux(i+1, j);
    }
}
