package com.sj902.tree;

import java.util.List;

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


public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode end = null;
        return sortedListToBSTAux(head, end);
    }

    private TreeNode sortedListToBSTAux(ListNode head, ListNode end) {
        if(head == null) return null;
        if(head == end) return null;
        ListNode mid = getMid(head, end);
        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBSTAux(head, mid);
        t.right = sortedListToBSTAux(mid.next, end);
        return t;
    }

    private ListNode getMid(ListNode head, ListNode end) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=end && fast.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
