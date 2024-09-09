package com.sj902.ll;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}


public class LLinBTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return aux(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean aux(TreeNode root, ListNode head) {
        if (head == null) return true;
        if (root == null) return false;
        if (root.val == head.val) {
            boolean a = aux(root.left, head.next);
            if (a) {
                return true;
            }
            boolean b = aux(root.right, head.next);
            return b;
        }
        return false;
    }
}
