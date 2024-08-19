package com.sj902.dp;

public class PalindromicSubstrings {
    Boolean[][] p;
    public int countSubstrings(String s) {
        p = new Boolean[s.length()][s.length()];
        int res = 0;
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                if (isPalindrome(s, i, i + l))
                    ++res;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int i, int j) {
        if(i >= j) return true;
        if(p[i][j]!=null) return p[i][j];
        if(s.charAt(i)!=s.charAt(j)) return p[i][j]=false;
        return p[i][j]=isPalindrome(s, ++i, --j);
    }
}