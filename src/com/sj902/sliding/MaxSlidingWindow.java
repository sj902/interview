package com.sj902.sliding;

import javafx.print.Collation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    static public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int begin = 0;
        int end = 0;

        while (end < k-1) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[end]) dq.removeLast();
            dq.addLast(end);
            ++end;
        }

        int[] res = new int[nums.length - k + 1];
        int q = 0;
        while (end < nums.length) {
            while (!dq.isEmpty() && dq.peekFirst() < begin)dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[end]) dq.removeLast();
            dq.addLast(end);
            res[q++] = nums[dq.peekFirst()];
            ++begin;
            System.out.println(end + ":" + dq);
            ++end;
        }
        return res;
    }
}
