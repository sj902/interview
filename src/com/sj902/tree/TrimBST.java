package com.sj902.tree;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val>=low && root.val<=high){
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
            return root;
        }
        if(root.val<low){
            return trimBST(root.right,low,high);
        }
        return trimBST(root.left,low,high);
    }
}
