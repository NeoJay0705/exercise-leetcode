package org.exercise.appdata.tree;

import org.exercise.inputs.TreeNode;

// 450

public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        root = dfs(root, key);
        return root;
    }

    public TreeNode dfs(TreeNode root, int key) {
        if ( root == null ) return root;

        if ( root.val == key ) {
            TreeNode tmpRoot = delete(root);
            if ( tmpRoot != null ) {
                if ( root.left != tmpRoot ) tmpRoot.left = root.left;
                if ( root.right != tmpRoot) tmpRoot.right = root.right;
            }
            root = tmpRoot;
        } 
        else if ( root.left != null && key == root.left.val ) {
            root.left = delete(root.left);
        }
        else if ( root.right != null && key == root.right.val ) {
            root.right = delete(root.right);
        } 
        else if ( key < root.val ) dfs(root.left, key);
        else  dfs(root.right, key);

        return root;
    }

    public TreeNode delete(TreeNode root) {
        TreeNode insteaded = findLastRightParent(root.left);
        if ( insteaded != null ) {
            if ( root.left != insteaded ) insteaded.left = root.left;
            insteaded.right = root.right;
        }
        else {
            insteaded = findLastLeftParent(root.right);
            if ( insteaded != null ) {
                if ( root.right != insteaded ) insteaded.right = root.right;
                insteaded.left = root.left;
            }
        }
        return insteaded;
    }

    public TreeNode findLastRightParent(TreeNode root) {
        if ( root == null ) return root;

        TreeNode parent = root;
        TreeNode lastRight = root.right;
        while ( lastRight != null && lastRight.right != null ) {
            parent = lastRight;
            lastRight = lastRight.right;
        }

        if ( lastRight == null ) return parent;
        else if ( lastRight.left == null ) {
            parent.right = null;
            return lastRight;
        }
        else { 
            parent.right = delete(lastRight);
            return lastRight;
        }
    }

    public TreeNode findLastLeftParent(TreeNode root) {
        if ( root == null ) return root;

        TreeNode parent = root;
        TreeNode lastLeft = root.left;
        while ( lastLeft != null && lastLeft.left != null ) {
            parent = lastLeft;
            lastLeft = lastLeft.left;
        }

        if ( lastLeft == null ) return parent;
        else if ( lastLeft.right == null ) {
            parent.left = null;
            return lastLeft;
        }
        else { 
            parent.left = delete(lastLeft);
            return lastLeft;
        }
    }
}
