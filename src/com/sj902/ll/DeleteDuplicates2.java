package com.sj902.ll;

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        System.out.println(head);
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;


        while (curr != null) {
            boolean f = false;
            while(curr.next!=null && curr.val == curr.next.val){
                f = true;
                curr.next = curr.next.next;
            }
            if(f){
                curr.val = curr.next.val;
                curr.next = curr.next.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
