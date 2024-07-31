package com.sj902.tree;

public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubtreeAux(root, subRoot, false);
    }

    public boolean isSubtreeAux(TreeNode root, TreeNode subRoot, boolean hasMatched) {
        if ((subRoot == null || root == null) && subRoot != root) return false;
        if (hasMatched) {
            return (root.val == subRoot.val && isSubtreeAux(root.right, subRoot.right, true) && isSubtreeAux(root.left, subRoot.left, true));
        }
        if(root.val == subRoot.val){
            return (isSubtreeAux(root.right, subRoot.right, true) && isSubtreeAux(root.left, subRoot.left, true)) || (isSubtreeAux(root.right, subRoot, false) || isSubtreeAux(root.left, subRoot, false));
        }
        return isSubtreeAux(root.right, subRoot, false) || isSubtreeAux(root.left, subRoot, false);
    }


}
