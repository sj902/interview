package com.sj902.dp;

import java.util.Arrays;

public class WiggleMaxLength {
    public int wiggleMaxLength(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            nums[i - 1] = arr[i] - arr[i - 1];
        }
        int[] dp = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if ((nums[i] > 0 && nums[j] < 0 && dp[i] < dp[j]) ||
                            (nums[i] < 0 && nums[j] > 0 && dp[i] < dp[j])
                    ) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt() + 1;
    }
}
