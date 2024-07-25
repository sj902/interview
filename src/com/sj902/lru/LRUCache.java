package com.sj902.lru;

import java.util.HashMap;

class ListNode {
    ListNode prev, next;
    int key, val;

    public ListNode(ListNode prev, ListNode next, int key, int val) {
        this.prev = prev;
        this.next = next;
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> map;

    ListNode head;
    ListNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(null, null, 0, 0);
        tail = new ListNode(null, null, 0, 0);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode n = map.get(key);
            remove(n);
            add(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode n = map.get(key);
            n.val = value;
            remove(n);
            add(n);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.key);
                removeTail();
            }
            ListNode t = new ListNode(null, null, key, value);
            add(t);
            map.put(key, t);
        }
    }

    void add(ListNode node) {
        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        }

        head = node;
        if (tail == null) {
            tail = node;
        }
    }


    void remove(ListNode node) {
        if (tail == node) {
            removeTail();
        } else {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
        }
    }

    void removeTail() {
        if (tail != null && tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        }
    }


    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
//        obj.put(1,1);
//        obj.put(2,2);
//        obj.put(3,3);
//        obj.put(4,4);
//        obj.put(5,5);
//        obj.put(6,6);
//        obj.put(7,7);
//        obj.put(6,6);
        obj.put(2, 1);
        obj.put(3, 2);
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        obj.put(4, 3);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
