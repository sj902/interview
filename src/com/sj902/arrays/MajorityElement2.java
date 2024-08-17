package com.sj902.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = nums[0];
        int b = nums[0];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != a) {
                b = nums[i];
                break;
            }
        }
        if (a == b) {
            res.add(a);
            return res;
        }
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == a){
                ++countA;
            } else if(nums[i] == b){
                ++countB;
            } else if (countA == 0) {
                a = nums[i];
                countA = 1;
            } else if (countB == 0) {
                b = nums[i];
                countB = 1;
            } else {
                countA--;
                countB--;
            }
        }
        int ca = 0;
        int cb = 0;
        for (int i = 0; i < n; i++) {
            if(a == nums[i]){
                ++ca;
            }
            if(b == nums[i]){
                ++cb;
            }
        }
        if(ca>n/3){
            res.add(a);
        }
        if(cb>n/3){
            res.add(b);
        }
        return res;
    }
}
