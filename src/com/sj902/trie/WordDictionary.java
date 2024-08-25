package com.sj902.trie;


import java.util.HashMap;

class TrieNode {
    boolean isLast;
    HashMap<Character, TrieNode> map;

    TrieNode() {
        map = new HashMap<>();
        isLast = false;
    }
}

class Trie {
    TrieNode start;

    Trie() {
        start = new TrieNode();
    }

    void add(String s) {
        TrieNode n = start;
        for (int i = 0; i < s.length(); i++) {
            n.map.putIfAbsent(s.charAt(i), new TrieNode());
            n = n.map.get(s.charAt(i));
        }
        n.isLast = true;
    }

    boolean search(String s) {
        return searchAux(s, start, 0);
    }

    private boolean searchAux(String s, TrieNode t, int idx) {
        if (idx == s.length() - 1) {
            return t.isLast;
        }
        char c = s.charAt(idx);
        if (c == '.') {
            for (char ch : t.map.keySet()) {
                boolean q = searchAux(s, t.map.get(ch), idx);
                if (q) return true;
            }
            return false;
        } else {
            if (t.map.containsKey(c)) {
                return searchAux(s, t.map.get(c), idx + 1);
            }
        }
        return false;
    }
}


public class WordDictionary {
    Trie t;

    public WordDictionary() {
        t = new Trie();
    }

    public void addWord(String word) {
        t.add(word);
    }

    public boolean search(String word) {
        return t.search(word);
    }
}
