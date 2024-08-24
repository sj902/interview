package com.sj902.dp;

public class FindMaxForm {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 4, 3));
        System.out.println(new Solution().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}

class Solution {
    Integer[][][] res;
    public int findMaxForm(String[] strs, int m, int n) {
        res = new Integer[m+1][n+1][strs.length+1];
        if (strs.length == 0) return 0;
        return aux(strs, m, n, 0);
    }

    private int aux(String[] strs, int m, int n, int idx) {
        if (m < 0 || n < 0) return 0;
        if (idx >= strs.length) return 0;
        int one = 0;
        int zero = 0;
        if(res[m][n][idx]!=null) return res[m][n][idx];
        for (int i = 0; i < strs[idx].length(); i++) {
            if (strs[idx].charAt(i) == '1') ++one;
            if (strs[idx].charAt(i) == '0') ++zero;
        }
        int include = (zero > m || one > n) ? 0 : 1 + aux(strs, m - zero, n - one, 1 + idx);
        int exclude = aux(strs, m, n, 1 + idx);
        return res[m][n][idx] = Math.max(include, exclude);
    }
}
