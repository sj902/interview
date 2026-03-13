package com.sj902.arrays;

public class IsValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            while (i <= s.length() - 1 && !Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) ++i;
            while (j >= 0 && !Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) --j;
            if (Math.abs(s.charAt(i) - s.charAt(j)) % 32 == 0) {
                ++i;
                --j;
            } else return false;
        }
        return true;
    }
}
