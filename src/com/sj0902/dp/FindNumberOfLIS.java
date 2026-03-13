package com.sj0902.dp;

import java.util.Arrays;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(lis, 1);
        int res = 0;
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            int maxLen = 1, maxCount = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int l = lis[j];
                    int c = count[j];
                    if (l + 1 > maxLen) {
                        maxLen = l + 1;
                        maxCount = c;
                    } else if (l + 1 == maxLen) {
                        maxCount += c;
                    }
                }
            }
            if(maxLen>len){
                len = maxLen;
                res = maxCount;
            } else if (maxLen == len) {
                res += maxCount;
            }
            lis[i] = maxLen;
            count[i] = maxCount;
        }

        return res;
    }
}
