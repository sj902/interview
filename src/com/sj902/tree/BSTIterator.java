package com.sj902.tree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        if (stack.isEmpty()) return -1;
        TreeNode p = stack.pop();
        int res = p.val;
        if(p.right!=null){
            p = p.right;
            stack.push(p);
            while (p.left!=null){
                stack.push(p.left);
                p = p.left;
            }
        }

        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
