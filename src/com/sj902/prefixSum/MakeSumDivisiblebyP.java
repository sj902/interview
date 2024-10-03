package com.sj902.prefixSum;

import java.util.Arrays;
import java.util.HashMap;

public class MakeSumDivisiblebyP {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        int[] prefix = new int[n];
        prefix[0] = nums[0] % p;
        sum = nums[0] % p;
        for (int i = 1; i < n; i++) {
            prefix[i] = (prefix[i - 1] + nums[i]) % p;
            sum = (sum + nums[i]) % p;
        }

        int diff = (int) (sum % p);

        System.out.println(sum + "::" + diff);
        System.out.println(Arrays.toString(prefix));
        int res = n;

        if (diff == 0)
            return 0;

        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int q = prefix[i];
            if (map.containsKey((q % p - diff + p) % p)) {
                res = Math.min(res, i - map.get((q % p - diff + p) % p));
            }
            map.put(prefix[i], i);
        }

        return res==n?-1:res;
    }
}
