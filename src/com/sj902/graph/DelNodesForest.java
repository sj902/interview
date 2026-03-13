package com.sj902.graph;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DelNodesForest {
    public List<TreeNode1> delNodes(TreeNode1 root, int[] to_delete) {
        List<TreeNode1> arr = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }

        boolean[] visited = new boolean[1000];

        dfs(visited, root, set, true, arr);

        return arr;
    }

    private void dfs(boolean[] visited, TreeNode1 root, HashSet<Integer> set, boolean parentDel, List<TreeNode1> res) {
        if (root == null) return;
        visited[root.val] = true;
        if (parentDel && !set.contains(root.val)) {
            res.add(root);
        }

        TreeNode1 left = root.left;
        TreeNode1 right = root.right;

        if(root.left!=null && set.contains(root.left.val)){
            root.left = null;
        }

        if(root.right!=null && set.contains(root.right.val)){
            root.right = null;
        }


        dfs(visited, left, set, set.contains(root.val), res);
        dfs(visited, right, set, set.contains(root.val), res);
    }
}
