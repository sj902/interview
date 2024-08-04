package com.sj902.tree;

public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        int dl = findDepth(x, root, 0);
        int dr = findDepth(y, root, 0);

        if (dl == dr) {
            return findParent(x, root) != findParent(y, root);
        }
        return false;
    }

    private int findDepth(int y, TreeNode root, int depth) {
        if (root == null) return -1;
        if(root.val == y) return depth;
        int left = findDepth(y, root.left, depth+1);
        int right = findDepth(y, root.right, depth+1);
        return Math.max(left, right);
    }

    private int findParent(int y, TreeNode root) {
        if (root == null) return -1;
        if(root.left != null && root.left.val == y) return root.val;
        if(root.right != null && root.right.val == y) return root.val;
        int left = findParent(y, root.right);
        int right = findParent(y, root.left);
        return Math.max(left, right);
    }
}
