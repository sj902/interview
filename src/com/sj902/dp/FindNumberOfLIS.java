package com.sj902.dp;

import java.util.Arrays;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    if (lis[j] + 1 == lis[i]) {
                        count[i] += count[j];
                    } else if (lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(lis));

        int lisr = Arrays.stream(lis).max().getAsInt();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] == lisr) {
                result += count[i];
            }
        }

        return result;
    }
}
