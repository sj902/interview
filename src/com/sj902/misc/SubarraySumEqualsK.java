package com.sj902.misc;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[nums.length+1];
        prefix[0] = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
            map.put(prefix[i+1], map.getOrDefault(prefix[i+1], 0) + 1);
            System.out.println(prefix[i+1]);
            if (k == 0) {
                res = res + map.get(prefix[i+1]) - 1;
                System.out.println(prefix[i+1]+"::"+ map.get(prefix[i+1]));
            } else {
                System.out.println(prefix[i+1] - k);
                int q = map.getOrDefault(prefix[i+1] - k, 0);
                res += q;
            }
        }

        return res;
    }
}
