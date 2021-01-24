package org.exercise.tree;

import org.exercise.zother.inputs.TreeNode;

// 235

public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null ) return null;

        /**
         *  Used in a non-BST
            if ( root.val == p.val || root.val == q.val ) return root;
            else { 
                TreeNode left = lowestCommonAncestor(root.left, p, q);
                TreeNode right = lowestCommonAncestor(root.right, p, q);
                if ( left != null && right != null ) return root;
                else if ( left != null || right != null ) return left != null ? left : right;
                else return null;
            }
         */
        

        if ( p.val <= root.val && q.val >= root.val ) return root;
        else if ( p.val >= root.val && q.val <= root.val ) return root;
        else if ( p.val < root.val && q.val < root.val ) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);

    }
}
