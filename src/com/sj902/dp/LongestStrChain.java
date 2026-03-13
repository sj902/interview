package com.sj902.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class LongestStrChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isChain(words[j], words[i])) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private boolean isChain(String word, String word1) {
        int m = word.length();
        int n = word1.length();
        if(m+1!=n) return false;
        int diff = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word.charAt(a) == word.charAt(b)){
                ++a;++b;
            } else{
                if(diff > 0 ) return false;
                diff++;
                ++b;
            }
        }
        return true;
    }
}
