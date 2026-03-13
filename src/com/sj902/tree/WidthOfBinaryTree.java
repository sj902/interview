//package com.sj902.tree;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class WidthOfBinaryTree {
//    HashMap<Integer, Long> max;
//    HashMap<Integer, Long> min;
//
//    public int widthOfBinaryTree(TreeNode root) {
//        max = new HashMap<>();
//        min = new HashMap<>();
//        int res = 0;
//        dfs(root, 0, 0);
//        dfs(root.left, 0, 1);
//        dfs(root.right, 1, 1);
//        for (int i : max.keySet()) {
//            System.out.println(i + "::" + max.get(i) + "::" + min.get(i));
//            res = (int)Math.max(res, max.get(i) - min.get(i));
//        }
//        return res + 1;
//    }
//
//    private void dfs(TreeNode root, long pos, int level) {
//        if (root == null) return;
//        System.out.println(root.val + "::" + pos);
//        long maxLevelVal = max.getOrDefault(level, Long.MIN_VALUE);
//        long minLevelVal = min.getOrDefault(level, Long.MAX_VALUE);
//        max.put(level, Math.max(pos, maxLevelVal));
//        min.put(level, Math.min(pos, minLevelVal));
//        dfs(root.left, pos * 2, level + 1);
//        dfs(root.right, (pos * 2) + 1, level + 1);
//    }
//}
