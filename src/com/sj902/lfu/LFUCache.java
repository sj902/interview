package com.sj902.lfu;

import java.util.HashMap;

class DLL {
    DLL next;
    DLL key;
    DLL prev;
    Node countNode;
    int value;
}

class Node {
    Node next;
    Node prev;
    int count;
    DLL keyList;
}

class LFUCache {
    int capacity;
    HashMap<Integer, DLL> map;
    HashMap<Integer, Node> countMap;

    Node countsFirst;
    Node countsLast;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        countMap = new HashMap<>();
        Node zeroNode = new Node();
        zeroNode.count = 0;
        Node lastNode = new Node();
        lastNode.count = 0;
        zeroNode.next = lastNode;
        lastNode.prev = zeroNode;
        countsFirst = zeroNode;
        countsLast = lastNode;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DLL dllNode = map.get(key);
        int value = dllNode.value;
        int count = dllNode.countNode.count + 1;
        delete(dllNode);
        put(key, value, count);

        return dllNode.value;
    }

    private void delete() {
        if(map.size() == 0) return;
        Node n = countsFirst.next;
        DLL dll = n.keyList;
        map.remove(dll.key);
        if(dll.next == null){
            n.prev.next = n.next;
            n.next.prev = n.prev;
            countMap.remove(n.count);
        } else {
            n.keyList = dll.next;
            dll.next.prev = null;
        }
    }

    private void delete(DLL dll) {
        Node n = dll.countNode;
        map.remove(dll.key);

        if(dll.prev == null && dll.next == null){
            n.prev.next = n.next;
            n.next.prev = n.prev;
            countMap.remove(n.count);
        } else if(dll.prev == null){
            n.keyList = dll.next;
            dll.next.prev = null;
        } else{
           dll.prev.next =dll.next;
           dll.next.prev =dll.prev;
        }
    }

    private void put(int key, int value, int count) {
//        if(countMap.c)
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLL dllNode = map.get(key);
            int count = dllNode.countNode.count + 1;
            delete(map.get(key));
            put(key, value, count);
        } else {
            if(capacity == map.size()){
                delete();
            } else {
                put(key, value, 1);
            }
        }

    }
}
