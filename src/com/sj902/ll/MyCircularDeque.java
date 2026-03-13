package com.sj902.ll;

class LN{
    LN next;
    LN prev;
    int val;
}

class MyCircularDeque {

    int size;
    int max;
    LN head;
    LN last;

    public MyCircularDeque(int k) {
        max = k;
    }

    public boolean insertFront(int value) {
        if(size == max) return false;
        LN l = new LN();
        l.val = value;
        if(size == 0){
            head = l;
            last = l;
            ++size;
            return true;
        }
        last.next = l;
        l.next = head;
        l.prev = last;
        head.prev = l;
        head = l;
        ++size;
        return true;
    }

    public boolean insertLast(int value) {
        if(size == max) return false;
        LN l = new LN();
        l.val = value;
        if(size == 0){
            head = l;
            last = l;
            ++size;
            return true;
        }
        last.next = l;
        l.next = head;
        l.prev = last;
        head.prev = l;
        last = l;
        ++size;
        return true;
    }

    public boolean deleteFront() {
        if(size == 0){return false;}
        if(size == 1){
            head = null;
            last = null;
            size = 0;
            return true;
        }

        last.next = head.next;
        head.next.prev = last;
        head = head.next;
        --size;
        return true;
    }

    public boolean deleteLast() {
        if(size == 0){return false;}
        if(size == 1){
            head = null;
            last = null;
            size = 0;
            return true;
        }

        last.prev.next = head;
        head.prev = last.prev;
        last = last.prev;
        --size;
        return true;
    }

    public int getFront() {
        if(size>0){
            return head.val;
        }
        return -1;
    }

    public int getRear() {
        if(size>0){
            return last.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */