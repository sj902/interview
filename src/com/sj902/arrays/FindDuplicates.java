package com.sj902.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int q = Math.abs(nums[i])-1;
            if(nums[q]<0){
                res.add(Math.abs(nums[i]));
            }
            nums[q] *=-1;
        }
        return res;
    }
}
