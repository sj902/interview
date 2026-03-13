package com.sj902.stack;

public class MinSwaps {
    public int minSwaps(String s) {
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '[':
                    open++;
                    break;
                case ']':
                    open = Math.max(open - 1, 0);
            }
        }
        return (open + 1) / 2;
    }
}
