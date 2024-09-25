package com.sj902.trie;

import java.util.HashMap;

class TrieNode {
    int count;
    HashMap<Character, TrieNode> map;

    public TrieNode() {
        this.count = 0;
        this.map = new HashMap<>();
    }
}

class Trie {
    TrieNode start;

    Trie() {
        start = new TrieNode();
    }

    void add(String word) {
        int n = word.length();
        TrieNode s = start;
        for (int i = 0; i < n; i++) {
            TrieNode nextNode = s.map.getOrDefault(word.charAt(i), new TrieNode());
            nextNode.count++;
            s.map.put(word.charAt(i), nextNode);
            s = nextNode;
        }
    }


    int traverse(String word) {
        int n = word.length();
        int res = 0;
        TrieNode s = start;
        for (int i = 0; i < n; i++) {
            TrieNode nextNode = s.map.get(word.charAt(i));
            res += nextNode.count;
            s = nextNode;
        }
        return res;
    }
}

public class SumPrefixScores {
    public int[] sumPrefixScores(String[] words) {
        Trie t = new Trie();
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

