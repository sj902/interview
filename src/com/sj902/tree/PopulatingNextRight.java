package com.sj902.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRight {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return root;
        q.add(root);
        while (!q.isEmpty()){
            int l = q.size();
            ArrayList<Node> arr = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                Node n = q.poll();
                if(n.left!=null){
                    q.add(n.left);
                    arr.add(n.left);
                }
                if(n.right!=null){
                    arr.add(n.right);
                    q.add(n.right);
                }
            }
            for (int i = 0; i < arr.size(); i++) {
                if(i == arr.size()-1){
                    arr.get(i).next = null;
                } else{
                    arr.get(i).next = arr.get(i+1);
                }
            }
        }
        return root;
    }
}
