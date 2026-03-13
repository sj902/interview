package com.sj0902;

import java.util.HashMap;

class DLL {
    DLL prev, next;
    int val;
    int key;

    public DLL(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

public class LRUCache {
    DLL head;
    DLL tail;
    int cap;
    HashMap<Integer, DLL> map;

    public LRUCache(int capacity) {
        cap = capacity;
        head = new DLL(-1, -1);
        tail = new DLL(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLL node = map.get(key);
            int res = node.val;
            remove(node);
            add(node);
            return res;
        } else {
            return -1;
        }
    }

    private void remove(DLL node) {
        DLL nPrev = node.prev;
        DLL nNext = node.next;
        nPrev.next = nNext;
        nNext.prev = nPrev;
    }

    private void add(DLL node) {
        DLL headNext = head.next;
        headNext.prev = node;
        node.next = headNext;
        head.next = node;
        node.prev = head;
    }

    public void put(int key, int value) {

        if (map.size() == cap && !map.containsKey(key)) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }

        DLL node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.val = value;
            remove(node);
        } else{
            node = new DLL(key, value);
        }
        map.put(key, node);
        add(node);
    }



}
