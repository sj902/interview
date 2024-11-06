package com.sj902;

public class MinChanges {
    public int minChanges(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(++i);
            if (c1 != c2) ++res;
        }
        return res;
    }
}
