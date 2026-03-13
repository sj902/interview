package com.sj902.tree;

import java.util.ArrayList;

public class PathSum3 {
    int res;
    int origTarget;
    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        origTarget = targetSum;
        ArrayList<Long> arr = new ArrayList<>();
        arr.add((long)targetSum);
        pathSumAux(root,arr);
        return res;
    }

    private void pathSumAux(TreeNode root, ArrayList<Long> arr) {
        if(root == null)return;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == root.val) ++res;
        }
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            a.add(arr.get(i)-root.val);
        }
        a.add((long)origTarget);
        pathSumAux(root.left, a);
        pathSumAux(root.right, a);
    }

}
