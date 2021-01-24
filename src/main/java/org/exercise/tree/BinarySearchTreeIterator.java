package org.exercise.tree;

import java.util.Deque;
import java.util.LinkedList;

import org.exercise.zother.inputs.TreeNode;

// 173

public class BinarySearchTreeIterator {
    private Deque<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        initialize(root);
    }

    private void initialize(TreeNode root) {
        if ( root == null ) return;

        stack.offerLast(root);
        while ( stack.peekLast().left != null ) {
            stack.offerLast(stack.peekLast().left);
        }
    }
    
    public int next() {
        TreeNode top = stack.pollLast();
        int val = top.val;
        initialize(top.right);
        return val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
