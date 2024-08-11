package com.sj902.graph;

import com.sj902.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int l = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                TreeNode t = q.poll();
                list.add(t.val);
                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);
            }
            res.add(list);
        }
        return res;
    }
}
