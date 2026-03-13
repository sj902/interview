package com.sj902;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = nums[i] + "";
        }
        Arrays.sort(s, (a, b) -> compare(a,b));
        StringBuilder sb = new StringBuilder();
        for (String value : s) {
            sb.append(value);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        if (sb.length() == 0) return "0";
        return sb.toString();
    }

    private int compare(String a, String b) {
       return  (b+a).compareTo(a+b);
    }
}
