package com.sj902.arrays;

import java.util.Stack;

public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        for (int i = nums.length-1; i >=1 ; i--) {
            while (!stack.isEmpty() && stack.peek()<=min[i])stack.pop();
            if(!stack.isEmpty() && stack.peek()<nums[i]){
                return true;
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
