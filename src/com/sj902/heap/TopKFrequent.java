package com.sj902.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i, 0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> map.get(b).compareTo(map.get(a)));
        for(int i: map.keySet())pq.add(i);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
