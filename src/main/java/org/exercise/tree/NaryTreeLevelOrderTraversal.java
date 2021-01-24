package org.exercise.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 429
// Can improve by rec, to see MaximumDepthofNaryTree

public class NaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null ) return result;

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        int levelLength = queue.size();

        while ( !queue.isEmpty() ) {
            int nextLevelLenght = 0;
            List<Integer> levelNodes = new LinkedList<>();
            for ( int i = 0; i < levelLength; ++i ) {
                Node firstNode = queue.pollFirst();
                levelNodes.add(firstNode.val);
                nextLevelLenght += firstNode.children.size();
                for ( Node child : firstNode.children ) {
                    queue.offerLast(child);
                }
            }
            levelLength = nextLevelLenght;
            result.add(levelNodes);
        }

        return result;
    }
}
