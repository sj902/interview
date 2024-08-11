package com.sj902.tree;

public class MaxPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        setSum(root);
        return max;
    }
    int setSum(TreeNode root){
        if(root == null) return 0;
        int l = setSum(root.left);
        int r = setSum(root.right);
        int a = root.val + l;
        int b = root.val + r;
        int c = root.val + l + r;
        max = Math.max(max, Math.max(a, Math.max(b, Math.max(c, root.val))));
        return Math.max(root.val, Math.max(a, Math.max(b, c)));
    }
}
