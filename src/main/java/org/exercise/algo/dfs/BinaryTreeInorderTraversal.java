package org.exercise.algo.dfs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.exercise.zother.inputs.TreeNode;

// 94

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Set<TreeNode> isVisted = new HashSet<>();
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while ( !stack.isEmpty() ) {
            TreeNode curr = stack.pollLast();
            if ( curr == null ) continue;
            
            if ( !isVisted.contains(curr) ) {
                isVisted.add(curr);
                stack.offerLast(curr.right);
                stack.offerLast(curr);
                stack.offerLast(curr.left);
            }
            else {
                result.add(curr.val);
            }
        }
        return result;
    }
}
