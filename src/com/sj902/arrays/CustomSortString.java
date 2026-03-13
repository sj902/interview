package com.sj902.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        ArrayList<Character> l = new ArrayList<>();
        for (char c: s.toCharArray()) {
            l.add(new Character(c));
        }
        Collections.sort(l, (a, b)-> map.get(a)-map.get(b));
        StringBuilder sb = new StringBuilder();
        for (char c:l) {
           sb.append(c);
        }
       return sb.toString();
    }
}
