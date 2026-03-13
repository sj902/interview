package com.sj902.arrays;

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int firstW = -1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                firstW = i;
                break;
            }
        }
        if (firstW == -1) return 0;

        int lastW = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                lastW = i;
                break;
            }
        }

        int min = firstW;
        for (int i = firstW; i <= lastW; i++) {
            if (nums[min] < nums[i]) {
                min = i;
            }
        }
        int max = firstW;
        for (int i = firstW; i <= lastW; i++) {
            if (nums[max] > nums[i]) {
                max = i;
            }
        }

        int correctLower = 0;
        while (correctLower < n && nums[correctLower] < nums[min]) {
            ++correctLower;
        }
        int correctHigher = n - 1;
        while (correctHigher >= 0 && nums[correctHigher] > nums[max]) {
            --correctHigher;
        }
        System.out.println(firstW+"::"+lastW+"::"+min+"::"+max+"::"+correctLower+"::"+correctHigher);
        return correctHigher - correctLower + 1;
    }
}
