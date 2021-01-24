package org.exercise.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.exercise.zother.inputs.TreeNode;

// 102

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);

        while ( !queue.isEmpty() ) {
            Deque<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> level = new LinkedList<>();
            while ( !queue.isEmpty() ) {
                TreeNode node = queue.pollFirst();
                if ( node != null ) {
                    level.add(node.val);
                    nextLevel.offerLast(node.left);
                    nextLevel.offerLast(node.right);
                }
            }
            queue = nextLevel;
            if ( !level.isEmpty() ) result.add(level);
        }

        return result;
    }
}
