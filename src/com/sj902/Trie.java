package com.sj902;

import java.util.HashMap;

class Solution{
    public static void main(String[] args) {
        Trie t  = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
    }
}

class TrieNode {
    HashMap<Character, TrieNode> map;
    boolean isEnd;

    public TrieNode() {
        this.isEnd = false;
        map = new HashMap<>();
    }
}

class Trie {
    TrieNode start;

    public Trie() {
        start = new TrieNode();
    }

    public void insert(String word) {
        TrieNode n = start;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!n.map.containsKey(c)) {
                n.map.put(c, new TrieNode());
            }
            n = n.map.get(c);
        }
        n.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode n = start;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!n.map.containsKey(c)) {
               return false;
            }
            n = n.map.get(c);
        }
        return n.isEnd;
    }


    public boolean startsWith(String word) {
        TrieNode n = start;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!n.map.containsKey(c)) {
                return false;
            }
            n = n.map.get(c);
        }
        return true;
    }


}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */






