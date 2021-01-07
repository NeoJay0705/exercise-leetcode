package org.exercise.appdata.tree;

import java.util.Deque;
import java.util.LinkedList;

import org.exercise.inputs.TreeNode;

// 104

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if ( root == null ) return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int count = 0;

        while ( !queue.isEmpty() ) {
            count++;
            int numInLevel = queue.size();
            for ( int i = 0; i < numInLevel; ++i ) {
                TreeNode node = queue.pollFirst();
                if ( node != null ) {
                    if ( node.left != null ) queue.offerLast(node.left);
                    if ( node.right != null ) queue.offerLast(node.right);
                }
                
            }
        }

        return count;
    }
}
