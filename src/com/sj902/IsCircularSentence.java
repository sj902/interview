package com.sj902;

public class IsCircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split("\\s+");
        if (s.length == 1) return s[0].charAt(s[0].length() - 1) == s[0].charAt(0);
        int len = s.length;
        char a = s[0].charAt(s[0].length() - 1);
        char b = ' ';
        for (int i = 1; i < len; i++) {
            b = s[i].charAt(0);
            System.out.println(a + "::" + b);
            if (a != b) return false;
            a = s[i].charAt(s[i].length() - 1);
        }
        return sentence.charAt(sentence.length() - 1) == sentence.charAt(0);
    }
}
