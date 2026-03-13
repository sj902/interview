package com.sj902.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < allowed.length(); ++i) {
            set.add(allowed.charAt(i));
        }
        int res = 0;
        for (String word : words) {
            boolean isGood = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) ++res;
        }
        return res;
    }
}