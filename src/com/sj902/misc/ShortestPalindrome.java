package com.sj902.misc;

class Q {
    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome("abcd"));
    }
}

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder().append(s).reverse().toString();
        int n = s.length();
        long front = 0;
        long back = 0;
        long mod = 1000000000 + 7;
        long hash = 29;
        long power = 1;

        int max = 0;
        for (int i = 0; i < n; i++) {
            int frontChar = (s.charAt(i) - 'a' + 1);
            int backChar = (rev.charAt(n - i - 1) - 'a' + 1);
            front = (front * hash + frontChar) % mod;
            back = (back + power * backChar);
            power = power * hash;
            if (front == back) {
                max = i+1;
            }
        }

        if (max == 0) return rev + s;
        return rev.substring(0,n-max) + s;
    }

}
