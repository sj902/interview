package com.sj902.ll;

class ListNode {
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
}

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        ListNode curr = head;
        while(curr!=null){
            ListNode last = curr;
            int q = 1;
            while(q<k && last!=null){
                last = last.next;
                q++;
            }
            ListNode p = curr;
            ListNode n = curr;
            while(curr!=null && curr!=last){
                n = curr.next;
                curr.next = p;
                p = curr;
                curr = n;
            }
            prev.next = p;
        }
        return dummy.next;
    }
}
