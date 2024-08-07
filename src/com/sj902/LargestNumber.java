package com.sj902;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];
                if(compare(a, b)){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n:nums) {
            sb.append(n);
        }
        int i = 0;
        while (i<sb.length() && sb.charAt(i)=='0') {
            sb.deleteCharAt(i);
            ++i;
        }
        return sb.length() == 0?"0":sb.toString();
    }

    private boolean compare(int a, int b) {
        return Long.parseLong(a+""+b)<Long.parseLong(b+""+a);
    }
}
