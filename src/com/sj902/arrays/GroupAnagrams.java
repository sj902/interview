package com.sj902.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res  = new ArrayList<>();

        HashMap<String, List<String>> map  = new HashMap<>();

        int n = strs.length;
        for (int i = 0; i < n; i++) {
            char[] ar = strs[i].toCharArray();
            Arrays.sort(ar);
            String s = Arrays.toString(ar);
            List<String> l = map.getOrDefault(s, new ArrayList<>());
            l.add(strs[i]);
            map.put(s, l);
        }
        for (String s:map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
        int  n = s.length();
        int l = 0;
        int r = n-1;
        s = s.toLowerCase();
        while (l<=r){
            while(l<r&&!(Character.isDigit(s.charAt(l))||Character.isAlphabetic(s.charAt(l)))){
                ++l;
            }
            while(r>l&&!(Character.isDigit(s.charAt(r))||Character.isAlphabetic(s.charAt(r)))){
                --r;
            }
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}
