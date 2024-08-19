package com.sj902.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencySort {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        Character[] arr = new Character[n];
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (a, b) -> {
            int freqCompare = map.get(b).compareTo(map.get(a));
            if (freqCompare != 0) {
                return freqCompare;
            }
            return Character.compare(a, b);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i].charValue());
        }
        return sb.toString();
    }
}
