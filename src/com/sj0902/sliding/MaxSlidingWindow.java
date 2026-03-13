package com.sj0902.sliding;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque();
        for (int i = 0; i < k-1; i++) {

                while (!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                    dq.removeLast();
                }
                dq.addLast(i);
        }

        int idx = k-1;
        int q = 0;
        while (idx<nums.length) {
            while(!dq.isEmpty() && dq.peekFirst()<=idx-k){
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()]<nums[idx]){
                dq.removeLast();
            }
            dq.addLast(idx++);
            res[q++] = nums[dq.peekFirst()];
        }
        return res;
     }
}
