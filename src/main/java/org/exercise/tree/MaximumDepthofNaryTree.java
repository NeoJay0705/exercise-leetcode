package org.exercise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 559

public class MaximumDepthofNaryTree {
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

    public int maxDepth(Node root) {
        List<List<Node>> levelTras = new ArrayList<>();
        if ( root == null ) return levelTras.size();

        dfs(root, 0, levelTras);
        return levelTras.size();
    }

    public void dfs(Node root, int level, List<List<Node>> levelTras) {
        if ( levelTras.size() == level ) levelTras.add(new LinkedList<>());
        levelTras.get(level).add(root);
        for ( Node child : root.children ) {
            dfs(child, level + 1, levelTras);
        }
    }
}
