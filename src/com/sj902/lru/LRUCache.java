package com.sj902.lru;

import java.util.HashMap;
import java.util.Map;

class DLL {
    int val;
    int key;
    DLL prev;
    DLL next;

    DLL(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    Map<Integer, DLL> map;
    DLL head;
    DLL tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        head = new DLL(-1, 0);
        tail = new DLL(-1, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key).val;
            remove(key);
            add(key, val);
            return val;
        } else return -1;
    }

    private void remove() {
        map.remove(head.next.key);
        DLL next = head.next.next;
        next.prev = head;
        head.next = next;
    }

    private void remove(int key) {
        DLL node = map.get(key);
        map.remove(key);
        DLL next = node.next;
        DLL prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    private void add(int key, int value) {
        DLL node = new DLL(key, value);
        DLL prev = tail.prev;
        prev.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prev;
        map.put(key, node);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
        } else if (size == capacity) {
            remove();
        } else {
            ++size;
        }
        add(key, value);
    }
}
