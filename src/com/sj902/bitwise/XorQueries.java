package com.sj902.bitwise;

public class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length+1];
        prefix[0] = 9;
        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i-1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefix[queries[i][0]] ^ prefix[queries[i][1]+1];
        }
        return res;
    }
}
