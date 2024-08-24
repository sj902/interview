package com.sj902.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    HashSet<String> dict;

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        return aux(s, 0, s.length() - 1);
    }

    private boolean aux(String s, int start, int end) {
        if (dict.contains(s.substring(start, end + 1))) return true;

        for (int i = start + 1; i < end; i++) {
            boolean k = aux(s, start, i) && aux(s, i + 1, end);
            if (k) return true;
        }
        return false;
    }
}
