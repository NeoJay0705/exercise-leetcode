package org.exercise.tree;

import org.exercise.zother.inputs.TreeNode;

// 236

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null ) return null;

        if ( root == p || root == q ) {
            return root;
        }
        else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if ( left != null && right != null ) return root;
            else if ( left == null && right == null ) return null;
            else return left != null ? left : right;
        }
    }
}
