package com.sj902.dp;

import java.util.Collections;
import java.util.HashSet;

public class MinExtraChar {
    HashSet<String> set;
    String str;
    Integer[] res;

    public int minExtraChar(String s, String[] dictionary) {
        res = new Integer[s.length() + 1];
        set = new HashSet<>();
        str = s;
        Collections.addAll(set, dictionary);
        return aux(0);
    }

    private int aux(int idx) {
        if (idx >= str.length()) {
            return 0;
        }
        if (res[idx] != null) return res[idx];
        int notTake;
        if (set.contains(str.substring(idx, idx + 1))) {
            notTake = aux(idx + 1);
        } else {
            notTake = 1 + aux(idx + 1);
        }
        int take = Integer.MAX_VALUE;
        for (int i = idx; i < str.length(); i++) {
            if (set.contains(str.substring(idx, i + 1))) {
                take = aux(i + 1);
            }
        }

        return res[idx] = Math.min(take, notTake);
    }
}
