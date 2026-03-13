package com.sj902.arrays;

import java.util.HashSet;

public class LongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> prefixes = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            String s = String.valueOf(arr1[i]);
            for (int j = 0; j < s.length(); j++) {
                prefixes.add(s.substring(0,j+1));
            }
        }
        int res = 0;
        for (int i = 0; i <arr2.length ; i++) {
            String s = String.valueOf(arr2[i]);
            for (int j = 0; j < s.length(); j++) {
                if(prefixes.contains(s.substring(0,j+1))){
                    res = Math.max(res, j+1);
                }
            }
        }
        return res;
    }
}
