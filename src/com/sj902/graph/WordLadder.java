package com.sj902.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 0;
        while (!q.isEmpty()) {
            ++res;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endWord)) return res;
                for (int j = 0; j < curr.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        String newCurr = curr.substring(0, j) + k + curr.substring(j + 1);
                        if (set.contains(newCurr)) {
                            q.add(newCurr);
                            set.remove(newCurr);
                        }
                    }
                }
            }
        }
        return res;
    }
}
