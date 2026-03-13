package com.sj0902.backtracking;

import java.util.Arrays;
import java.util.HashSet;

public class SmallestNumber {
    String p;

    public String smallestNumber(String pattern) {
        int n = pattern.length() + 1;

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            char curr = pattern.charAt(i);
            int q = i;
            while (q < n - 1 && pattern.charAt(q) == curr) {
                ++q;
            }
            if (curr == 'D') {
                int start = i;
                int end = q - 1;
                while (start < end) {
                    int t = res[start];
                    res[start] = res[end];
                    res[end] = t;
                    ++start;
                    --end;
                }
            }
            i = q - 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i);
        }
        return sb.toString();
    }
}
