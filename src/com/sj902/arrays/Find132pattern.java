package com.sj902.arrays;

import java.util.Stack;

public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i]<s3)return false;
            while (!stack.isEmpty() && stack.peek()<nums[i]){
                nums[i] = stack.peek();
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
