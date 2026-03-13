package com.sj902.tree;

import java.util.HashMap;

public class HouseRobber3 {
    HashMap<TreeNode, HashMap<Boolean, Integer>> map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return Math.max(robAux(root, false), robAux(root, true));
    }

    private int robAux(TreeNode root, boolean wasParentIncluded) {
        if (root == null) return 0;
        if (map.containsKey(root) && map.get(root).containsKey(wasParentIncluded))
            return map.get(root).get(wasParentIncluded);
        if (!wasParentIncluded) {
            HashMap<Boolean, Integer> m = map.getOrDefault(root, new HashMap<>());
            int k = Math.max(robAux(root.left, false) + robAux(root.right, false),
                     root.val + robAux(root.left, true) + robAux(root.right, true));
            m.put(wasParentIncluded, k);
            map.put(root, m);
            return k;
        } else {
            HashMap<Boolean, Integer> m = map.getOrDefault(root, new HashMap<>());
            int k = robAux(root.left, false) + robAux(root.right, false);
            m.put(wasParentIncluded, k);
            map.put(root, m);
            return k;
        }
    }
}
