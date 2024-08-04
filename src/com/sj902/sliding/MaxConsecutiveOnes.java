package com.sj902.sliding;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int len = 0;
        int counter = k;


        int start = 0;
        int end = 0;
        int n = nums.length;
        while(end<n){
            int c = nums[end];
            if(c == 0) counter--;
            ++end;
            while(counter<=k){
               int q = nums[start];
               if(q == 0) counter ++;
               ++start;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }
}
