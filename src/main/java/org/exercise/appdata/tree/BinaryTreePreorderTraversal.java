package org.exercise.appdata.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.exercise.inputs.TreeNode;

// 144

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);

        while ( !stack.isEmpty() ) {
            TreeNode node = stack.pollLast();
            if ( node != null ) {
                result.add(node.val);
                stack.offerLast(node.right);
                stack.offerLast(node.left);
            }
        }

        return result;
    }
}
