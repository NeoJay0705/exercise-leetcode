package org.exercise.tree;

import org.exercise.zother.inputs.TreeNode;

// 98

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root.left, root.val, Integer.MAX_VALUE, root.val, false, true, false) && dfs(root.right, root.val, Integer.MIN_VALUE, root.val, true, false, false);
    }

    public boolean dfs(TreeNode root, int parent, int grand, int top, boolean atRight, boolean isLeft, boolean ismid) {
        if ( root == null ) return true;

        if ( ismid ) {
            if ( isLeft ) return root.val < parent && root.val > grand
                          && dfs(root.left, root.val, parent, grand, true, true, false)
                          && dfs(root.right, root.val, parent, parent, atRight, false, true);
            else return root.val > parent && root.val < grand
                 && dfs(root.left, root.val, parent, parent, atRight, true, true)
                 && dfs(root.right, root.val, parent, grand, false, false, false);
        } 
        else {
            if ( isLeft && !atRight ) return root.val < parent 
                                           && dfs(root.left, root.val, parent, top, false, true, false)
                                           && dfs(root.right, root.val, parent, top, false, false, true); 
            else if ( !isLeft && atRight ) return root.val > parent 
                                                && dfs(root.left, root.val, parent, top, true, true, true) 
                                                && dfs(root.right, root.val, parent, top, true, false, false);
            else if ( !atRight ) return root.val > parent && root.val < top 
                                        && dfs(root.left, root.val, parent, parent, false, true, true) 
                                        && dfs(root.right, root.val, parent, top, false, false, false); 
            else return root.val < parent && root.val > top
                            && dfs(root.left, root.val, parent, top, true, true, false)
                            && dfs(root.right, root.val, parent, parent, true, false, true);
        }

        

        
    }
}
