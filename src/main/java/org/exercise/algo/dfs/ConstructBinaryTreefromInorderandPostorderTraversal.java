package org.exercise.algo.dfs;

import java.util.HashMap;
import java.util.Map;

import org.exercise.zother.inputs.TreeNode;

// 106
// can improve

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ( postorder.length == 0 ) return null;

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for ( int i = 0; i < inorder.length; ++i ) {
            inorderMap.put(inorder[i], i);
        }

        helper(postorder, postorder.length - 2, root, 0, inorderMap);

        return root;
    }

    public int helper(int[] postorder, int nextIndex, TreeNode root, int parentOrder, Map<Integer, Integer> inorderMap) {
        if ( nextIndex < 0 ) return -1;

        TreeNode nextNode = new TreeNode(postorder[nextIndex]);
        if ( inorderMap.get(nextNode.val) > inorderMap.get(root.val) ) {
            root.right = nextNode;
            nextIndex = helper(postorder, nextIndex - 1, nextNode, inorderMap.get(root.val), inorderMap);
        }
        
        
        if ( nextIndex != -1 ) {
            nextNode = new TreeNode(postorder[nextIndex]);
            if( inorderMap.get(nextNode.val) >= parentOrder ) {
                root.left = nextNode;
                nextIndex = helper(postorder, nextIndex - 1, nextNode, parentOrder, inorderMap);
            }
        }
        
        return nextIndex;
    }
}
