package com.sj902.tree;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if(root.val<low){
            return rangeSumBST(root.right, low, high);
        }
        char c = 'a';
        if(root.val>high){
            return rangeSumBST(root.left, low, high);
        }
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        return root.val+left+right;
    }
}
