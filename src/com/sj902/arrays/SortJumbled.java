package com.sj902.arrays;

import java.util.Arrays;
import java.util.Comparator;

class T {
    int index;
    int num;
    int newNum;

    public T(int index, int num, int[] mapping) {
        this.index = index;
        this.num = num;
        this.newNum = getNewNum(mapping, num);
    }

    private int getNewNum(int[] mapping, int num) {
        String n = num + "";
        StringBuilder newN = new StringBuilder();
        for (char c : n.toCharArray()) {
            int q = Integer.parseInt(c + "");
            newN.append(mapping[q]);
        }
        return Integer.parseInt(newN.toString());
    }
}

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        T[] arr = new T[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new T(i, nums[i], mapping);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.newNum == o2.newNum) {
                return o1.index - o2.index;
            }
            return o1.newNum - o2.newNum;
        });

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i].num;
        }
        return res;
    }
}
