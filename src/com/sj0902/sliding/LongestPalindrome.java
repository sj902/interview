package com.sj0902.sliding;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            int k = getMax(s, i);
            if (k > res.length()) {
                res = s.substring(i - k + 1, i + k);
            }
        }
        for (int i = 1; i < n; i++) {
            int k = getMax2(s, i);
            if (k > res.length()) {
                int len = k/2;
                res = s.substring(i - len, i + len);
            }
        }
        return res;
    }

    private int getMax2(String s, int i) {
        int l = i - 1;
        int r = i;
        if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        --l;
        ++r;
        int counter = 2;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            counter = counter +2;
            --l;
            ++r;
        }
        return counter;
    }

    private int getMax(String s, int i) {
        int l = i - 1;
        int r = i + 1;
        int counter = 1;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            ++counter;
            --l;
            ++r;
        }
        return counter;
    }
}
