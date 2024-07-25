package com.sj902.sliding;

public class LongestPalindrome {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < n; ++i) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < n) {
                boolean isPali = isPalindrome(s.substring(l, r + 1));
                if (isPali && (r - l + 1) > maxLen) {
                    maxLen = (r - l + 1);
                    leftMax = l;
                    rightMax = r;
                }
                --l;
                ++r;
            }
        }

        for (int i = 1; i < n; ++i) {
            int l = i - 2;
            int r = i + 1;
            while (l >= 0 && r < n) {
                boolean isPali = isPalindrome(s.substring(l, r + 1));
                if (isPali && (r - l + 1) > maxLen) {
                    maxLen = (r - l + 1);
                    leftMax = l;
                    rightMax = r;
                }
                --l;
                ++r;
            }
        }
        return s.substring(leftMax, rightMax + 1);
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
