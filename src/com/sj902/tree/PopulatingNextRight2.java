package com.sj902.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRight2 {
    public Node connect(Node root) {

        if(root.left!=null){
            Node l;
            if(root.right!=null){
                l = root.right;
            } else if (root.next!=null && root.next.left!=null){
                l = root.next.left;
            } else if(root.next!=null && root.next.right!=null){
                l = root.next.right;
            } else {
                Node n = root.next;
                while(n != null && n.next != null && (n.next.left == null && n.right.left == null )){
                    n = n.next;
                }
                l = n;
            }

            root.left.next   = l;
            connect(root.left);
        }
        if(root.right!=null){
            Node l;
            if (root.next!=null && root.next.left!=null){
                l = root.next.left;
            } else if(root.next!=null && root.next.right!=null){
                l = root.next.right;
            } else {
                Node n = root.next;
                while(n != null && n.next != null && (n.next.left == null && n.right.left == null )){
                    n = n.next;
                }
                l = n;
            }

            root.right.next   = l;
            connect(root.right);
        }
        return root;
    }
}
