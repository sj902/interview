package com.sj902.ll;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode curr = dummy;

        while (curr != null && curr.next != null) {
            int c = curr.val;
            ListNode n = curr.next;
            while (n.val == c) {
                curr.next = n.next;
                n = n.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
