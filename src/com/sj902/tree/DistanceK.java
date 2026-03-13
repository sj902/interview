package com.sj902.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistanceK {
    //    left = 0
//    right = 1
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, Integer> dist = new HashMap<>();
        HashMap<TreeNode, Integer> dir = new HashMap<>();
        dfsFind(root, target, dist, dir);
        List<Integer> res = new ArrayList<>();

        for (TreeNode t : dist.keySet()) {
            if (dist.get(t) == 0) {
                find(t.left, k, res);
                find(t.right, k, res);
            } else {
                if (dir.get(t) == 0) {
                    find(t.right, k - dist.get(t), res);
                } else {
                    find(t.left, k - dist.get(t), res);
                }
            }
        }
        return res;
    }

    private void find(TreeNode left, int i, List<Integer> res) {
        if (left == null) return;
        if (i == 0) {
            res.add(left.val);
            return;
        }
        find( left.left, i-1,  res);
        find( left.right, i-1,  res);
    }

    private boolean dfsFind(TreeNode root, TreeNode target, HashMap<TreeNode, Integer> dist, HashMap<TreeNode, Integer> dir) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            dist.put(root, 0);
            dir.put(root, 0);
            return true;
        }

        if (dfsFind(root.left, target, dist, dir)) {
            dist.put(root, dist.get(root.left) + 1);
            dir.put(root, 0);
            return true;
        }
        if (dfsFind(root.right, target, dist, dir)) {
            dist.put(root, dist.get(root.right) + 1);
            dir.put(root, 1);
            return true;
        }
        return false;
    }
}
