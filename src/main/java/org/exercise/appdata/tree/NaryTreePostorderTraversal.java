package org.exercise.appdata.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 590

public class NaryTreePostorderTraversal {
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
    
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if ( root == null ) return result;

        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);
        
        while ( !deque.isEmpty() ) {
            Node topNode = deque.pollLast();
            result.add(0, topNode.val);
            for ( int i = 0; i < topNode.children.size(); ++i ) {
                deque.offerLast(topNode.children.get(i));
            }
        }

        return result;
    }

    public List<Integer> postorder_rec(Node root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null ) return result;

        dfs(root, result);
        return result;
    }

    public void dfs(Node root, List<Integer> result) {
        for ( Node child : root.children ) {
            dfs(child, result);
        }
        result.add(root.val);
    }
}
