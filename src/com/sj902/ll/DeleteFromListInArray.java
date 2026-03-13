package com.sj902.ll;

import java.util.HashSet;
import java.util.Set;

public class DeleteFromListInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        while (curr != null) {
            if (curr.next != null && set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
