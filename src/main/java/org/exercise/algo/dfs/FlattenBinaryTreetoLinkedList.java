package org.exercise.algo.dfs;

import org.exercise.zother.inputs.TreeNode;

// 114

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode curNode) {
        if ( curNode == null ) return null;

        if ( curNode.right == null && curNode.left == null ) {
            return curNode;
        }

        TreeNode tmpRight = curNode.right;
        curNode.right = curNode.left;
        curNode.left = null;
        TreeNode leftCur = helper(curNode.right);
        
        if ( leftCur == null ) {
            curNode.right = tmpRight;
        }
        else leftCur.right = tmpRight;

        if ( tmpRight == null ) return leftCur;
        
        return helper(tmpRight);
    }
}
