package com.sj902.lfu;

import java.util.HashMap;

class DLL{
    DLL next;
    DLL prev;
    int count;
}

//class Node{
//    Node
//}

class LFUCache {
    int capacity;
    int max;
    HashMap<Integer, Integer> map;
    HashMap<Integer, DLL> countMap;


//    public LFUCache(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>();
//        timeMap = new HashMap<>();
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//
//    }
}
