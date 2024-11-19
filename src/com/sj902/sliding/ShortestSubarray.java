package com.sj902.sliding;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> dq = new LinkedList<>();
        int res = n + 1;

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                res = Math.min(res, i - dq.pollFirst());
            }

            while (!dq.isEmpty() && prefixSum[dq.peekLast()] >= prefixSum[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }


        return res <= n ? res : -1;
    }
}
