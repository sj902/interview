package com.sj902.lfu;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {

    HashMap<Integer, Pair<Integer, Integer>> map;
    HashMap<Integer, LinkedHashSet<Integer>> fmap;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        fmap = new HashMap<>();
        minFreq = Integer.MAX_VALUE;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int res = map.get(key).getKey();
        int freq = map.get(key).getValue();
        fmap.get(freq).remove(key);
        LinkedHashSet<Integer> set = fmap.getOrDefault(freq + 1, new LinkedHashSet<>());
        set.add(key);
        map.remove(key);
        if (fmap.get(freq).isEmpty()) {
            if (minFreq == freq) {
                minFreq = freq + 1;
            }
            fmap.remove(freq);
        }
        fmap.put(freq + 1, set);
        map.put(key, new Pair<>(res, freq + 1));
        return res;
    }

    public void put(int key, int value) {
        int frequency = 1;
        if (map.containsKey(key)) {
            // remove this
            int freq = map.get(key).getValue();
            fmap.get(freq).remove(key);

            map.remove(key);
            if (fmap.get(freq).isEmpty()) {
                if (minFreq == freq) {
                    minFreq += 1;
                }
                fmap.remove(freq);
            }
            frequency = freq + 1;


        } else if (map.size() == this.capacity) {
            frequency = 1;
            int freq = minFreq;
            LinkedHashSet<Integer> set = fmap.get(freq);
            int first = set.iterator().next();
            fmap.get(freq).remove(first);
            map.remove(first);
            if (fmap.get(freq).isEmpty()) {
                fmap.remove(freq);
            }
            minFreq = 1;
        }
        // add this
        LinkedHashSet<Integer> set = fmap.getOrDefault(frequency, new LinkedHashSet<>());
        set.add(key);
        fmap.put(frequency, set);
        map.put(key, new Pair<>(value, frequency));
        minFreq = Math.min(frequency, minFreq);
    }
}