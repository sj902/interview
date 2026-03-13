package com.sj902;

public class MyAtoi {
    public int myAtoi(String s1) {
        String s = s1.trim();
        if(s.length() == 0) return 0;
        boolean isNeg = s.charAt(0)=='-';
        int i = isNeg?1:0;
        long res = 0;
        if(s.charAt(0)=='+') ++i;
        while (i<s.length()){

            if(Character.isDigit(s.charAt(i))){
                res = (res*10) + (s.charAt(i)-'0');
            }
            else break;

            if (res > Integer.MAX_VALUE) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ++i;
        }
        if(res<Integer.MIN_VALUE) return isNeg?Integer.MAX_VALUE:Integer.MIN_VALUE;
        return (int)(isNeg?res*-1:res);
    }
}
