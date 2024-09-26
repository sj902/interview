package com.sj902.trie;

import java.util.HashMap;

class TrieNode11 {
    int count;
    HashMap<Character, TrieNode11> map;

    public TrieNode11() {
        this.count = 0;
        this.map = new HashMap<>();
    }
}

class Trie11 {
    TrieNode11 start;

    Trie11() {
        start = new TrieNode11();
    }

    void add(String word) {
        int n = word.length();
        TrieNode11 s = start;
        for (int i = 0; i < n; i++) {
            TrieNode11 nextNode = s.map.getOrDefault(word.charAt(i), new TrieNode11());
            nextNode.count++;
            s.map.put(word.charAt(i), nextNode);
            s = nextNode;
        }
    }


    int traverse(String word) {
        int n = word.length();
        int res = 0;
        TrieNode11 s = start;
        for (int i = 0; i < n; i++) {
            TrieNode11 nextNode = s.map.get(word.charAt(i));
            res += nextNode.count;
            s = nextNode;
        }
        return res;
    }
}

public class SumPrefixScores {
    public int[] sumPrefixScores(String[] words) {
        Trie11 t = new Trie11();
        for(String word: words){
            t.add(word);
        }
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = t.traverse(words[i]);
        }
        return res;
    }
}

