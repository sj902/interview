package com.sj902.graph;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class UF {
    int[] parent;
    String s;

    UF(String s) {
        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        this.s = s;
    }

    int find(int i) {
        if (parent[i] == i) return parent[i];
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA == pB) return;
        if (s.charAt(pA) == s.charAt(pB)) {
            if (a < b) {
                parent[pB] = pA;
                parent[b] = pA;
            } else {
                parent[pA] = pB;
                parent[a] = pB;
            }
        } else if (s.charAt(pA) < s.charAt(pB)) {
            parent[pB] = pA;
            parent[b] = pA;
        } else {
            parent[pA] = pB;
            parent[a] = pB;
        }
    }
}

class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UF u = new UF(s);
        for (List<Integer> pair : pairs) {
            u.union(pair.get(0), pair.get(1));
        }
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            PriorityQueue<Character> pq = map.getOrDefault(u.find(i), new PriorityQueue<>());
            pq.add(s.charAt(i));
            map.put(u.find(i), pq);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            PriorityQueue<Character> pq = map.getOrDefault(u.find(i), new PriorityQueue<>());
            if (!pq.isEmpty()){
                sb.append(pq.poll());
            }
        }
        return sb.toString();
    }
}
