package com.sj902.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 1) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a2 -> a2.freq));
        int[] res = new int[k];
        for (int i : map.keySet()) {
            pq.add(new Pair(i, map.get(i)));
        }
        for(int i = 0; i< k; ++i){
            res[i] = pq.poll().num;
        }
        return res;
    }
}