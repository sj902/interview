package com.sj902.graph;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val) return p;

        if (p.val == root.val || q.val == root.val) return root;

        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) return root;

        if (p.val < root.val) return lowestCommonAncestor(root.left, p,q);
        return lowestCommonAncestor(root.right, p,q);
    }
}
