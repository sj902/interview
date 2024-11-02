package com.sj902;

public class MakeFancyString {
    public String makeFancyString(String s) {
        int currCount = 0;
        char curr = ' ';
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (curr == ch) {
                if (currCount < 2) {
                    ++currCount;
                    sb.append(ch);
                }
            } else {
                currCount = 1;
                sb.append(ch);
            }
            curr = ch;
        }
        return sb.toString();
    }
}
