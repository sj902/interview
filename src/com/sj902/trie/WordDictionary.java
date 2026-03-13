package com.sj902.trie;


import java.util.HashMap;

class TrieNodeasdf {
    boolean isLast;
    HashMap<Character, TrieNodeasdf> map;

    TrieNodeasdf() {
        map = new HashMap<>();
        isLast = false;
    }
}

class Trieert {
    TrieNodeasdf start;

    Trieert() {
        start = new TrieNodeasdf();
    }

    void add(String s) {
        TrieNodeasdf n = start;
        for (int i = 0; i < s.length(); i++) {
            n.map.putIfAbsent(s.charAt(i), new TrieNodeasdf());
            n = n.map.get(s.charAt(i));
        }
        n.isLast = true;
    }

    boolean search(String s) {
        return searchAux(s, start, 0);
    }

    private boolean searchAux(String s, TrieNodeasdf t, int idx) {
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
    Trieert t;

    public WordDictionary() {
        t = new Trieert();
    }

    public void addWord(String word) {
        t.add(word);
    }

    public boolean search(String word) {
        return t.search(word);
    }
}
