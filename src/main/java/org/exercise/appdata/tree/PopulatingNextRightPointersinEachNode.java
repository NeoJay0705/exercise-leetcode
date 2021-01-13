package org.exercise.appdata.tree;

import java.util.Deque;
import java.util.LinkedList;

// 116

public class PopulatingNextRightPointersinEachNode {
    private class Node {
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
    }
    
    public Node connect(Node root) {
        if ( root == null ) return null;

        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);

        while ( !queue.isEmpty() ) {
            int levelLength = queue.size();
            Node left = queue.pollFirst();
            if ( left.left != null ) {
                queue.offerLast(left.left);
                queue.offerLast(left.right);
            }
            Node right = null;
            for ( int i = 1; i < levelLength; ++i ) {
                right = queue.pollFirst();
                if ( right.left != null ) {
                    queue.offerLast(right.left);
                    queue.offerLast(right.right);
                }
                left.next = right;
                left = right;
            }
            left.next = null;
        }

        return root;
    }

    public Node connect_rec(Node root) {
        if ( root == null ) return null;

        dfs(root);
        return root;
    }

    public void dfs(Node root) {
        if ( root.left == null ) return;
        root.left.next = root.right;
        root.right.next = root.next != null ? root.next.left : null;
        dfs(root.left);
        dfs(root.right);
    }
}
