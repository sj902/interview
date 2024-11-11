package com.sj902.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
    LinkedHashMap<Integer, Integer> lhm;

    public LRU(int capacity) {
        lhm = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
       return lhm.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        lhm.put(key, value);
    }
}
