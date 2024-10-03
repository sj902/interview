package com.sj902.stringMatching;

public class StringMatching {
    public int strStr(String haystack, String needle) {
        int[] prefix = new int[needle.length()];
        prefix[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            int j = prefix[i - 1];
            if (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = prefix[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }

        int i = 0;
        int j = 0;

        while (i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)){
                ++i;++j;
            } else if(j>0){
                j = prefix[j-1];
            } else {
                ++i;
            }
        }
        return j == needle.length() ? i - j : -1;
    }
}
