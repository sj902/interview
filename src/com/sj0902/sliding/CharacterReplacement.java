package com.sj0902.sliding;

import java.util.HashMap;

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = Math.max(res, characterReplacement(s, k, (char)('A'+i)));
        }
        return res;
    }

    public int characterReplacement(String s, int k, char ch) {
        int l = 0, r = 0;
        int counter = 0;
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if(c != ch){
                ++counter;
            }
            ++r;
            while (counter>k) {
                char q = s.charAt(l);
                if(q != ch){
                    ++l;
                    --counter;
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
