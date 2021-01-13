package org.exercise.appdata.tree;

import java.util.Deque;
import java.util.LinkedList;

// 117
// Can improve by recursion

public class PopulatingNextRightPointersinEachNodeII {
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
            if ( left.left != null ) queue.offerLast(left.left);
            if ( left.right != null ) queue.offerLast(left.right);
            Node right = null;
            for ( int i = 1; i < levelLength; ++i ) {
                right = queue.pollFirst();
                if ( right.left != null ) queue.offerLast(right.left);
                if ( right.right != null ) queue.offerLast(right.right);
                left.next = right;
                left = right;
            }
            left.next = null;
        }

        return root;
    }

    public Node connect_rec(Node root) {
        scan(root);
        return root;
    }

    public void scan(Node root) {
        /**
         * fail
         */
        if ( root == null ) return;
        if ( root.left != null ) {
            Node currRoot = root;
            Node nextNode = root.right;
            while ( nextNode == null && currRoot.next != null ) {
                currRoot = currRoot.next;
                nextNode = currRoot.left != null ? currRoot.left : currRoot.right;
            }
            root.left.next = nextNode;
        }

        if ( root.right != null ) {
            Node currRoot = root;
            Node nextNode = null;
            while ( nextNode == null && currRoot.next != null ) {
                currRoot = currRoot.next;
                nextNode = currRoot.left != null ? currRoot.left : currRoot.right;
            }
            root.right.next = nextNode;
        }

        scan(root.next);
        scan(root.left);
        scan(root.right);
    }
}
