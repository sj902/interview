package com.sj902.tree;

public class RecoverTree {
    TreeNode first, second, last, prev;

    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        last = null;
        prev = null;
        inorder(root);
        if (last != null) {
            int tmp = first.val;
            first.val = last.val;
            last.val = tmp;
        } else {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void inorder(TreeNode root) {
        inorder(root.left);
        if(prev.val>root.val){
            if(first == null){
                first = prev;
                second = root;
            } else {
                last = root;
            }
        }
        prev = root;
    }
}
