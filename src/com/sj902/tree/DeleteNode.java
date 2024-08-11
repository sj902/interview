package com.sj902.tree;

public class DeleteNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = null;  // This represents the 'null' in the list
        TreeNode node6 = new TreeNode(7);

        // Construct the tree
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node6;

        deleteNode(root, 3);
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode tn = root.right;
            while (tn.left!=null) tn = tn.left;
            root.val = tn.val;
            root.right = deleteNode(root.right, tn.val);
        } else if (root.val > key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

}
