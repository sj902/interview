package com.sj902.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> val = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                TreeNode t = q.poll();
                if(t.left!=null)q.offer(t.left);
                if(t.right!=null)q.offer(t.right);
                val.add(t.val);
            }
            res.add(val);
        }
        return res;
    }
}
