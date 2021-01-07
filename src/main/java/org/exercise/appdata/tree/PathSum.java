package org.exercise.appdata.tree;

import org.exercise.inputs.TreeNode;

// 112

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if ( root == null ) return false;
        if ( root.left == null && root.right == null && sum == root.val ) return true;
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = false;
        if ( left == false ) right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }
}
