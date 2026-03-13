package com.sj902.ll;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
       ListNode curr = this;
       String str = "";
       while (curr!=null){
           str = str + curr.val +"->";
           curr = curr.next;
       }
       return str;
    }
}