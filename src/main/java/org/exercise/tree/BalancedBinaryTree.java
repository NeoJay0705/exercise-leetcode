package org.exercise.tree;

import org.exercise.zother.inputs.TreeNode;

// 110

public class BalancedBinaryTree {
    private class Val {
        int i;
        boolean balanced;
        Val(int i, boolean bal) { 
            this.i = i; 
            balanced = bal;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return helper(root).balanced;
    }

    public Val helper(TreeNode root) {
        if ( root == null ) {
            return new Val(0, true);
        }

        Val left = helper(root.left);
        Val right = helper(root.right);

        if ( left.balanced && right.balanced ) {
            left.balanced = Math.abs(left.i - right.i) < 2;
            left.i = Math.max(left.i, right.i) + 1;
        }
        else left.balanced = false;

        return left;
    }
}
