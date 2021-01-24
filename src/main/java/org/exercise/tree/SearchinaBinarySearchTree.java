package org.exercise.tree;

import org.exercise.zother.inputs.TreeNode;

// 700

public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if ( root == null ) return null;

        if ( root.val == val ) return root;
        if ( val < root.val ) return searchBST(root.left, val);
        if ( val > root.val ) return searchBST(root.right, val);

        return null;
    }
}
