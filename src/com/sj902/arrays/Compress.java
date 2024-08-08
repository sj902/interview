package com.sj902.arrays;

import java.util.Arrays;

public class Compress {
    public static void main(String[] args) {
        char[] c = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(c));
        System.out.println(Arrays.toString(c));
    }

    public static int compress(char[] chars) {
        int i = 0;
        int j = 0;
        while (j < chars.length) {
            char curr = chars[i];
            int count = 0;
            while (j<chars.length && chars[j] == curr){
                ++j;
                ++count;
            }
            chars[i++] = curr;
            if(count>1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[i++] = c;
                }
            }
        }

        return i;
    }
}
