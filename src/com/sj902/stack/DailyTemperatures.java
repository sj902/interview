package com.sj902.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            if (stack.isEmpty()) {
                res[i] = 0;
                stack.push(i);
            } else if (temperatures[stack.peek()] >= temperatures[i]) {
                res[i] = stack.peek() - i;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = 0;
                    stack.push(i);
                } else {
                    res[i] = stack.peek() - i;
                    stack.push(i);
                }
            }

        }
        return res;
    }
}
