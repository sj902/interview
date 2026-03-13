package com.sj0902.dp;

public class CountSubstrings {
    Boolean[][] p;
    public int countSubstrings(String s) {
        int res = 0;
        p = new Boolean[s.length()][s.length()];
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    ++res;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if(start >= end) return true;
        if(p[start][end]!=null){
            return p[start][end];
        }
        if(s.charAt(start)!=s.charAt(end)){
            return p[start][end] = false;
        } else{
            return p[start][end] = isPalindrome(s, ++start, --end);
        }
    }
}
