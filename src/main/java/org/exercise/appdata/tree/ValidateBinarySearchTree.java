package org.exercise.appdata.tree;

import org.exercise.inputs.TreeNode;

// 98

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root.left, root.val, Integer.MAX_VALUE, false, true) && dfs(root.right, root.val, Integer.MIN_VALUE, true, false);
    }

    public boolean dfs(TreeNode root, int parent, int grand, int top, boolean atRight, boolean isLeft) {
        if ( root == null ) return true;
        boolean highCheck = atRight ? root.val > grand : root.val < grand;
        if ( isLeft && !atRight ) return root.val < parent 
                                         && dfs(root.left, root.val, parent, top, atRight, true)
                                         && dfs(root.right, root.val, parent, top, atRight, false);
        else if ( !isLeft && atRight ) return root.val > parent 
                                              && dfs(root.left, root.val, parent, grand, atRight, true)
                                              && dfs(root.right, root.val, parent, top, atRight, false);
        else if ( !atRight ) return root.val > parent && root.val < top 
                                    && dfs(root.left, root.val, parent, parent, true, true)
                                    && dfs(root.right, root.val, parent, top, atRight, false);
        else return root.val < parent && root.val > top
                    && dfs(root.left, root.val, parent, top, atRight, true)
                    && dfs(root.right, root.val, parent, top, atRight, false);
        
        if ( isLeft ) return root.val < parent && root.val > grand;
        else return root.val > parent && root.val < grand;

        return (isLeft ? root.val < parent : root.val > parent) && highCheck
               && dfs(root.left, root.val, parent, atRight, true)
               && dfs(root.right, root.val, parent, atRight, false);
    }
}
