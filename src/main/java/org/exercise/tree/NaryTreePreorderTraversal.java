package org.exercise.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 589

public class NaryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    public List<Integer> preorder(Node root) {
        if ( root == null ) return new LinkedList<>();

        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.offerLast(root);

        while ( !stack.isEmpty() ) {
            Node topNode = stack.pollLast();
            for ( int i = topNode.children.size() - 1; i > -1; --i ) {
                stack.offerLast(topNode.children.get(i));
            }
            result.add(topNode.val);
        }

        return result;
    }

    public List<Integer> preorder_rec(Node root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null ) return result;

        dfs(root, result);
        return result;
    }

    public void dfs(Node root, List<Integer> result) {
        result.add(root.val);
        for ( Node child : root.children ) {
            dfs(child, result);
        }
    }
}
