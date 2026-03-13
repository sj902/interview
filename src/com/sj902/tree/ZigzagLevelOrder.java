package com.sj902.tree;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean f = true;
        while (!q.isEmpty()){
            int l = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                TreeNode t = q.poll();
                list.add(t.val);
                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);
            }
            if(f) {
                res.add(list);
            } else{
                Collections.reverse(list);
                res.add(list);
            }
            f = !f;
        }
        return res;
    }
}
