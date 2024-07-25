package com.sj902.sliding;

import java.util.HashMap;

public class MinimalSubstr {
//    public String minWindow(String s, String t) {
//        if(t.length()> s.length()) return "";
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(Character c: t.toCharArray()){
//            map.put(c, map.getOrDefault(c, 0)+1);
//        }
//
//        int left = 0;
//        int right = 0;
//        String res = "";
//        int i = 0;
//        int n = s.length();
//        int counter = map.size();
//
//
//        while(i<n){
//            char c = s.charAt(i);
//            if(map.containsKey(c)){
//                map.put(c, map.get(c)-1);
//                if(map.get(c)==0)counter--;
//            }
//            ++i;
//
//            while (counter==t.length()){
//
//            }
//        }
//    }
}
