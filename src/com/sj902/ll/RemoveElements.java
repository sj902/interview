package com.sj902.ll;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode curr = dummy;
        while (curr!=null && curr.next!=null){
            ListNode n = curr.next;
            while(n!=null && n.val == val){
                curr.next = n.next;
                n = n.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
