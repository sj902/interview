package com.sj902.graph;


import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class GoodLeafPairs {
    public int countPairs(TreeNode root, int distance) {
        return dfs(root, distance, new ArrayList<>());
    }

    public int dfs(TreeNode root, int distance, ArrayList<Integer> arr) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            arr.add(1);
        }

        ArrayList<Integer> left = new ArrayList<>();
        int a = dfs(root.left, distance, left);
        ArrayList<Integer> right = new ArrayList<>();
        int b = dfs(root.right, distance, right);

        int c = 0;
        for (int q : left) {
            for (int w : right) {
                if (q + w <= distance)
                    c++;
            }
        }
        for (int q : left) {
            arr.add(q + 1);
        }
        for (int w : right) {
            arr.add(w + 1);
        }


        return a + b + c;
    }
}
