package org.exercise.tree;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.exercise.zother.inputs.TreeNode;

// 145

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Set<TreeNode> isVisted = new HashSet<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);

        while ( !stack.isEmpty() ) {
            TreeNode node = stack.pollLast();
            if ( node != null ) {
                if ( !isVisted.contains(node) ) {
                    stack.offerLast(node);
                    stack.offerLast(node.right);
                    stack.offerLast(node.left);
                    isVisted.add(node);
                }
                else {
                    result.add(node.val);
                }
            }
        }

        return result;
    }
}
