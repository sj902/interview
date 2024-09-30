package com.sj902.ll;

import java.util.HashMap;
import java.util.HashSet;

class Node {
    int freq;
    HashSet<String> keys;
    Node next;
    Node prev;

    public Node() {
        keys = new HashSet<>();
    }
}

class AllOne {
    HashMap<String, Node> map;
    Node head;
    Node tail;


    public AllOne() {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        head.freq = -1;
        tail.freq = -1;
    }

    public void inc(String key) {
        boolean present = map.containsKey(key);
        if (!present) {
            if (head.next.freq == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            } else {
                Node freq1 = new Node();
                freq1.freq = 1;
                freq1.keys.add(key);
                map.put(key, freq1);
                insert(freq1, head, head.next);
            }
        } else {
            Node currNode = map.get(key);
            if (currNode.next.freq == currNode.freq + 1) {
                Node freq1 = currNode.next;
                freq1.keys.add(key);
                map.put(key, freq1);
            } else {
                Node freq1 = new Node();
                freq1.freq = currNode.freq + 1;
                freq1.keys.add(key);
                map.put(key, freq1);
                insert(freq1, currNode, currNode.next);
            }
            currNode.keys.remove(key);
            if (currNode.keys.isEmpty()) {
                remove(currNode);
            }
        }
    }

    private void remove(Node currNode) {
        Node prev = currNode.prev;
        Node next = currNode.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node newNode, Node prevNode, Node nextNode) {
        prevNode.next = newNode;
        newNode.prev = prevNode;
        nextNode.prev = newNode;
        newNode.next = nextNode;
    }

    public void dec(String key) {
        Node currNode = map.get(key);
        if (currNode.freq == 1) {
            currNode.keys.remove(key);
            map.remove(key);
        } else {
            Node prev = currNode.prev;
            if (prev.freq == currNode.freq - 1) {
                prev.keys.add(key);
                map.put(key, prev);
            } else {
                Node newNode = new Node();
                newNode.freq = currNode.freq - 1;
                newNode.keys.add(key);
                map.put(key, newNode);
                insert(newNode, prev, currNode);
            }
            currNode.keys.remove(key);
        }

        if (currNode.keys.isEmpty()) {
            remove(currNode);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}
