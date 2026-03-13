package com.sj902.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DividePlayers {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int groups = n / 2;
        long sum = 0;
        Arrays.sort(skill);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            sum += skill[i];
        }
        if (sum % groups != 0) return -1;
        int target = (int) (sum / groups);


        int res = 0;
        for (int i = 0; i < groups; i++) {
            int a = skill[i];
            int b = skill[n - i - 1];
            if (a + b == target) {
                res += (a * b);
            } else {
                return -1;
            }
        }
        return res;
    }
}
