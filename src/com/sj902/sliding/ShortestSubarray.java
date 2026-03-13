package com.sj902.sliding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();

        int res = n + 1;

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefixSum[i] < prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }

            while (!dq.isEmpty() && prefixSum[dq.peekLast()] - prefixSum[dq.peekFirst()] >= k) {
                res = Math.min(res, dq.peekLast() - dq.peekFirst() + 1);
                dq.pollFirst();
            }

            dq.offerLast(i);
        }


        return res == n + 1 ? -1 : res;
    }
}
