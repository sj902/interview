package com.sj902.sliding;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PowerOfKSize {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int q = 0;
        int[] result = new int[n - k + 1];

//        Deque<Integer> temp = new LinkedList<>();
//        temp.addLast(nums[0]);
        int temp = 1;
        int last = nums[0];


        for (int i = 1; i < k - 1; i++) {
//            if (temp.getLast() + 1 != nums[i]) {
//                temp.clear();
//            }
//            temp.addLast(nums[i]);


            if (last + 1 != nums[i]) {
                temp = 0;
            }
            ++temp;
            last = nums[i];
        }

        for (int i = k - 1; i < n; i++) {
//            if (temp.getLast() + 1 != nums[i]) {
//                temp.clear();
//            }

            if (last + 1 != nums[i]) {
                temp = 0;
            }
            if (temp == k) {
                temp--;
            }

//            temp.addLast(nums[i]);
            ++temp;
            last = nums[i];

//            if (temp.size() == k) {
            if (temp == k) {
                result[q++] = nums[i];
            } else {
                result[q++] = -1;
            }
        }

        return result;
    }
}
