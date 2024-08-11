package com.sj902.tree;

public class BstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderAux(preorder, 0, preorder.length-1);
    }

    public TreeNode bstFromPreorderAux(int[] preorder, int start, int end) {
        if (start < 0 || start >= preorder.length || end < 0 || end >= preorder.length) return null;
        int pivot = preorder[start];
        int i = start;
        TreeNode root = new TreeNode(pivot);
        if(start > end) return null;
        if(start == end) return root;
        while (i <= end && preorder[i] <= pivot) ++i;
        root.left = bstFromPreorderAux(preorder, start + 1, i-1);
        root.right = bstFromPreorderAux(preorder, i, end);

        return root;
    }
}
