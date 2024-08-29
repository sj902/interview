package com.sj902.misc;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int size = ((max - min) / ((nums.length) - 1)) + 1;
        int count = ((max - min) / size) + 1;
        int[][] buckets = new int[count][3];
        for (int[] i : buckets) {
            i[0] = Integer.MAX_VALUE;
            i[1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - min) / size;
            buckets[idx][2] = 1;
            buckets[idx][0] = Math.min(buckets[idx][0], nums[i]);
            buckets[idx][1] = Math.max(buckets[idx][1], nums[i]);
        }


        int res = Integer.MIN_VALUE;
        int prevMax = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            if(buckets[i][2] == 1){
                res = Math.max(res, buckets[i][0] - prevMax);
                prevMax = buckets[i][1];
            }
        }
        return res;
    }
}
