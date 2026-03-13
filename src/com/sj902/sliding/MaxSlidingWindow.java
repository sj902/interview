package com.sj902.sliding;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int begin = 0;
        int end = 0;
        int l = 0;
        while (end-begin+1<k){
            while (!dq.isEmpty() && nums[dq.peekLast()]<nums[end]) dq.removeLast();
            dq.addLast(end++);
        }
        while (end<n){
            while (!dq.isEmpty() && nums[dq.peekLast()]<nums[end]) dq.removeLast();
            while (!dq.isEmpty() && dq.peekFirst()<begin) dq.removeFirst();
            dq.addLast(end);
            res[l++] = dq.peekFirst();
            ++end;
            ++begin;
        }
        return res;
    }
}
