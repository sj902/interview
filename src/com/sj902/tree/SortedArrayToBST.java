package com.sj902.tree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return sortedArrayToBSTAux(nums, 0, n-1);
    }

    private TreeNode sortedArrayToBSTAux(int[] nums, int start, int end) {
        if(start>end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int mid = (start+end)/2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = sortedArrayToBSTAux( nums,  start, mid-1);
        res.right = sortedArrayToBSTAux( nums,  mid+1, end);
        return res;
    }
}
