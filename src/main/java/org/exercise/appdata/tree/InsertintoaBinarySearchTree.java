package org.exercise.appdata.tree;

import org.exercise.inputs.TreeNode;

// 701

public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if ( root == null ) return new TreeNode(val);

        dfs(root, val);
        return root;
    }

    public void dfs(TreeNode root, int val) {
        if ( val < root.val ) {
            if ( root.left == null ) root.left = new TreeNode(val);
            else dfs(root.left, val);
        }
        else {
            if ( root.right == null ) root.right = new TreeNode(val);
            else dfs(root.right, val);
        }
    }
}
