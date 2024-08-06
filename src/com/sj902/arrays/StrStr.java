package com.sj902.arrays;

import java.util.HashSet;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = n - 1;
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder(haystack.substring(0, n - 1));
        while (j < m) {
            sb.append(haystack.charAt(j));
            visited.add(sb.toString());
            if (visited.contains(needle)) return i;
            sb.deleteCharAt(0);
            ++i;
            ++j;
        }
        return -1;
    }
}
