package org.exercise.tree;

import org.exercise.zother.inputs.TreeNode;

// 226

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if ( root == null ) return;

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
    }
}
