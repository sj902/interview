package com.sj902.graph;

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return dfs(root, -101);
    }

    private int dfs(TreeNode root, int max) {
        if(root == null) return 0;
        int res = 0;
        if (root.val>max){
            ++res;
            res += dfs(root.left, root.val);
            res += dfs(root.right, root.val);
        } else {
            res += dfs(root.left, max);
            res += dfs(root.right, max);
        }
        return res;
    }

}
