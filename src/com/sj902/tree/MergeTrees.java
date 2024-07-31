package com.sj902.tree;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null && root2 != null) return root2;
        if(root1!=null && root2 == null) return root1;

        TreeNode n = new TreeNode(root1.val+root2.val);
        n.left = mergeTrees(root1.left,root2.left);
        n.right = mergeTrees(root1.right,root2.right);
        return n;
    }
}
